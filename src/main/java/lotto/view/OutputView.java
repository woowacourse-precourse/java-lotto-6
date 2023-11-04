package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private StringBuilder outputMessage = new StringBuilder();
    public void printPurchasedLotteries(List<Lotto> lotteries) {
        outputMessage.append(lotteries.size()).append("개를 구매했습니다.").append("\n");

        for (Lotto lotto : lotteries) {
            outputMessage.append(lotto.getNumbers()).append("\n");
        }

        System.out.println(outputMessage);
    }

    public void printWinningStatistics() {

    }

    public void printProfitPercentage() {

    }
}
