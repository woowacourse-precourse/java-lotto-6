package lotto.controller;

import lotto.model.Player;
import lotto.service.LottoService;

public class LottoGame {
    private final LottoService lottoService = new LottoService();
    private Player player;
    private static final int DIVIDED_AMOUNT = 1000;

    public void start() {
        lottoService.createLottoCount();
        player = new Player(lottoService.getPayment());
        play();
    }

    private void play() {
        lottoService.play();
        lottoService.createWinningNumbers();
    }

}
