package lotto.controller;

import lotto.service.LottoGameService;

public class LottoGame {
    public static void run() {

        LottoGameService.purchaseLotto();

        LottoGameService.requestWinningLotto();

        LottoGameService.figureOutLottoGame();

        LottoGameService.calculateTotalRateOfReturn();

        LottoGameService.endLottoGame();
    }
}
