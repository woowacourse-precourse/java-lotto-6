package lotto.domain;

import lotto.domain.lottery.Lotto;

import java.util.List;

public class LotteryMessageBuilder {

    public String returnLottoList(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto :
                lottos) {
            sb.append(lotto).append("\n");
        }

        return sb.toString();
    }

    public String returnWinningLottoList() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public String returnLotteryProfit() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public String returnFinalLotteryStats() {
        return returnWinningLottoList() + returnLotteryProfit();
    }
}
