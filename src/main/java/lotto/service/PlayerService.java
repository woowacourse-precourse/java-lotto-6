package lotto.service;

import lotto.domain.Player;

public class PlayerService {

    private Player player;
    private LottoGenerator lottoGenerator;

    public PlayerService(Player player, LottoGenerator lottoGenerator) {
        this.player = player;
        this.lottoGenerator = lottoGenerator;
    }

    public void buy(int lottoCount){

    }

    public void check(){

    }
}
