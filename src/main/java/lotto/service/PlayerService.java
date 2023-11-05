package lotto.service;

import lotto.domain.Player;

public class PlayerService {

    private Player player;
    private LottoGenerator lottoGenerator;
    private WinningLottoCalculator winningLottoCalculator;

    public PlayerService(Player player, LottoGenerator lottoGenerator, WinningLottoCalculator winningLottoCalculator) {
        this.player = player;
        this.lottoGenerator = lottoGenerator;
        this.winningLottoCalculator = winningLottoCalculator;
    }

    public void buy(int lottoCount){

    }

    public void check(){
    }
}
