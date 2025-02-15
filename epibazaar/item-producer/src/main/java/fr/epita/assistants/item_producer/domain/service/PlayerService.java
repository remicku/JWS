package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.data.repository.GameRepository;
import fr.epita.assistants.item_producer.data.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PlayerService {
    @Inject
    PlayerRepository playerRepository;

    @Inject
    GameRepository gameRepository;

    public PlayerModel getPlayerData() {
        if (gameRepository.count() == 0)
            throw new RuntimeException("PlayerService: getPlayerData: Game has not started");

        PlayerModel player = playerRepository.findAll().list().getFirst();

        if (player == null)
            throw new RuntimeException("PlayerService: getPlayerData: No player has been found");

        return player;
    }
}
