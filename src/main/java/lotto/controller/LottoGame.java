package lotto.controller;

import lotto.model.Player;
import lotto.service.LottoService;
import lotto.service.StatsService;

public class LottoGame {
    private final LottoService lottoService = new LottoService();
    private StatsService statsService;
    private Player player;
    private static final int DIVIDED_AMOUNT = 1000;

    public void start() {
        lottoService.createLottoCount();
        play();
    }

    private void play() {
        lottoService.play();
        lottoService.createWinningNumbers();
        lottoService.createBonusNumber();
        player = new Player(lottoService.getPayment(), lottoService.getWinningNumbers(), lottoService.getBonusNumber());
        statsService = new StatsService(player);
        statsService.calculateWinnings(lottoService.getLottos());
    }

}
