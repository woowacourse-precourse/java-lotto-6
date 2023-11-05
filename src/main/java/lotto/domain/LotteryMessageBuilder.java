package lotto.domain;

public class LotteryMessageBuilder {

    public String returnLottoList() {
        StringBuilder sb = new StringBuilder();

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
