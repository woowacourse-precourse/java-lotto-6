package lotto.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.LottoBuyer;
import lotto.domain.Lottos;
import lotto.domain.WinningRank;

public class OutputView {

    public void lottoPurchaseCountMessage(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public void lottoNumbersMessage(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void winningHistoryMessage(LottoBuyer lottoBuyer) {
        String winningHistory = getWinningHistory(lottoBuyer);
        String message = String.format(
                "%n당첨 통계%n---%n%s",
                winningHistory
        );

        System.out.println(message);
    }

    private static String getWinningHistory(LottoBuyer lottoBuyer) {
        return Arrays.stream(WinningRank.values())
                .map(winningRank -> winningRank.getMessage(lottoBuyer))
                .collect(Collectors.joining("\n"));
    }

    public void TotalReturnRateMessage(LottoBuyer lottoBuyer, int inputPrice) {
        double totalPrizeMoney = calculateTotalPrizeMoney(lottoBuyer) / inputPrice * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", totalPrizeMoney);
    }

    private double calculateTotalPrizeMoney(LottoBuyer lottoBuyer) {
        return Arrays.stream(WinningRank.values())
                .mapToDouble(winningRank -> calculateIndividualPrizeMoney(winningRank, lottoBuyer))
                .sum();
    }

    private int calculateIndividualPrizeMoney(WinningRank winningRank, LottoBuyer lottoBuyer) {
        return winningRank.getPrizeMoney() * lottoBuyer.getWinCount(winningRank);
    }
}
