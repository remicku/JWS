package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import fr.epita.assistants.common.command.ResetInventoryCommand;
import fr.epita.assistants.item_producer.data.model.GameModel;
import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.data.repository.GameRepository;
import fr.epita.assistants.item_producer.data.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StartService {
    @Inject
    GameRepository gameRepository;

    @Inject
    PlayerRepository  playerRepository;

    @Inject
    @Channel("reset-inventory-command")
    Emitter<ResetInventoryCommand> resetInventoryEmitter;

    public String mapToRLE(String mapPath) {
        try {
            StringBuilder str = new StringBuilder(Files.readString(Path.of(mapPath)).replace("\n", ";"));
            return str.deleteCharAt(str.length() - 1).toString();
        } catch (IOException e) {
            throw new IllegalArgumentException("StartService: mapToRLE: invalid mapPath provided: " + mapPath);
        }
    }

    public List<List<ItemAggregate.ResourceType>> parseMap(String rleMap) {
        List<List<ItemAggregate.ResourceType>> res = new ArrayList<>();
        int i = 0;
        int len = rleMap.length();

        while (i < len) {
            List<ItemAggregate.ResourceType> list = new ArrayList<>();

            while (i < len && rleMap.charAt(i) != ';') {
                int quantity = Character.getNumericValue(rleMap.charAt(i));
                char type = rleMap.charAt(i + 1);

                int j = 0;

                while (j < quantity) {
                    list.add(ItemAggregate.ResourceType.getResource(type));
                    j++;
                }

                i += 2;
            }

            if (!list.isEmpty())
                res.add(list);
            i++;
        }

        return res;
    }

    @Transactional
    public List<List<ItemAggregate.ResourceType>> initGame(String mapPath) {
        String rleMap = mapToRLE(mapPath);
        List<List<ItemAggregate.ResourceType>> map = parseMap(rleMap);

        gameRepository.deleteAll();
        playerRepository.deleteAll();

        GameModel game = new GameModel(rleMap);
        gameRepository.persist(game);

        PlayerModel player = new PlayerModel(0, 0, 1.0f, 1.0f, 1.0f, null, null);
        playerRepository.persist(player);

        return map;
    }

    public List<List<ItemAggregate.ResourceType>> startGame(String mapPath) {
        List<List<ItemAggregate.ResourceType>> map = initGame(mapPath);
        resetInventoryEmitter.send(new ResetInventoryCommand());
        return map;
    }
}
