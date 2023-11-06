package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LotteryService;

import java.util.List;

public class LotteryController {
    LotteryService lotteryService = new LotteryService();

    public void start() {
        List<Lotto> lottos = lotteryService.issueLottery();
        lotteryService.setWinningLottery();
        lotteryService.getWinningResults(lottos);
    }
}
