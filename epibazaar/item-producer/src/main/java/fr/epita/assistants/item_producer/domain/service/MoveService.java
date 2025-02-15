package fr.epita.assistants.item_producer.domain.service;


import fr.epita.assistants.common.aggregate.ItemAggregate;
import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.data.repository.GameRepository;
import fr.epita.assistants.item_producer.data.repository.PlayerRepository;
import fr.epita.assistants.item_producer.domain.entity.MoveEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ApplicationScoped
public class MoveService {
    @Inject
    PlayerRepository playerRepository;

    @Inject
    GameRepository gameRepository;

    @ConfigProperty(name = "JWS_TICK_DURATION") long tick;
    @ConfigProperty(name = "JWS_DELAY_MOVEMENT") long delay;

    public boolean isWalkable(int x, int y) {
        List<List<ItemAggregate.ResourceType>> map = StartService.parseMap(gameRepository.findAll().list().getFirst().getMap());

        if (y < 0 || y >= map.size() || x < 0 || x >= map.getFirst().size())
            return false;

        List<ItemAggregate.ResourceType> row = map.get(y);
        ItemAggregate.ResourceType tile = row.get(x);

        if (tile.getItemInfo().isWalkable())
            return true;

        return false;
    }

    public MoveEntity getNewCoordinates(String direction, PlayerModel player) {
        int newX = player.getPosX();
        int newY = player.getPosY();

        switch (direction) {
            case "UP" -> newY--;
            case "DOWN" -> newY++;
            case "LEFT" -> newX--;
            case "RIGHT" -> newX++;
            default -> throw new IllegalArgumentException("MoveService: movePlayer: Invalid direction");
        }

        return new MoveEntity(newX, newY);
    }

    @Transactional
    public MoveEntity movePlayer(String direction) {
        PlayerModel player = playerRepository.findAll().list().getFirst();

        MoveEntity move = getNewCoordinates(direction, player);

        if (isWalkable(move.posX, move.posY) && (player.getLastMove() == null ||
                LocalDateTime.now().isAfter(player.getLastMove()
                        .plus((long) ((tick * delay) / player.getMoveSpeedMultiplier()), ChronoUnit.MILLIS)))) {
            player.setPosX(move.posX);
            player.setPosY(move.posY);
            player.setLastMove(LocalDateTime.now());
        }
        else if (LocalDateTime.now().isBefore(player.getLastMove()
                        .plus((long) ((tick * delay) / player.getMoveSpeedMultiplier()), ChronoUnit.MILLIS)))
            throw new ArithmeticException("Too fast");
        else
            throw new RuntimeException("MoveService: movePlayer: Target tile is non walkable");

        return new MoveEntity(player.getPosX(), player.getPosY());
    }
}
