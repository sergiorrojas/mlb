package com.sergiroj.mlb.service.impl;

import com.sergiroj.mlb.dto.request.service.CreatePlayerRequest;
import com.sergiroj.mlb.dto.request.service.UpdatePlayerRequest;
import com.sergiroj.mlb.dto.response.service.PlayerResponse;
import com.sergiroj.mlb.entity.Player;
import com.sergiroj.mlb.repository.PlayerRepository;
import com.sergiroj.mlb.service.PlayerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Completable;
import rx.Observable;
import rx.Single;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public String createPlayer(CreatePlayerRequest createPlayerRequest) {
        return null;
    }

    @Override
    public Single<String> createPlayerV2(CreatePlayerRequest createPlayerRequest) {
        return null;
    }

    @Override
    public List<PlayerResponse> getAllPlayers() {
        return null;
    }

    @Override
    public Single<List<PlayerResponse>> getAllPlayersV2() {
        return null;
    }

    @Override
    public Observable<List<PlayerResponse>> getAllPlayersV3() {
        return null;
    }

    @Override
    public Single<PlayerResponse> getPlayerDetailsV2(String id) {
        return null;
    }

    @Override
    public Completable updatePlayerV2(UpdatePlayerRequest updatePlayerRequest) {
        return null;
    }

    @Override
    public Completable deletePlayerV2(String id) {
        return null;
    }

    private String savePlayer(CreatePlayerRequest createPlayerRequest){
        return playerRepository.save(convertToPlayer(createPlayerRequest)).getId();
    }

    private Player convertToPlayer(CreatePlayerRequest createPlayerRequest){
        Player player = new Player();
        BeanUtils.copyProperties(createPlayerRequest, player);
        player.setId(UUID.randomUUID().toString());
        return player;
    }

    private PlayerResponse convertToPlayerResponse(Player player){
        PlayerResponse playerResponse = new PlayerResponse();
        BeanUtils.copyProperties(player, playerResponse);
        return playerResponse;
    }

    private boolean updatePlayerRepository(UpdatePlayerRequest updatePlayerRequest) {
        Optional<Player> optionalPlayer = playerRepository.findById(updatePlayerRequest.getId());
        if(!optionalPlayer.isPresent()){
            return false;
        }
        else{
            Player player = optionalPlayer.get();
            player.setName(updatePlayerRequest.getName());
            playerRepository.save(player);
            return true;
        }
    }

    private boolean removePlayerRepository(String id){
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if(!optionalPlayer.isPresent()){
            return false;
        }
        else{
            playerRepository.delete(optionalPlayer.get());
            return true;
        }
    }

    private PlayerResponse getPlayer(String id){
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        return convertToPlayerResponse(optionalPlayer.get());
    }


}
