package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printBuyLotto() {
        System.out.printf("%d개를 구매했습니다.%n", buyLotto);
    }

    public static void printWinReward(String winReward) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(winReward);
    }

    public static void printProfitRate() {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printIssuedLottoDetails(List<Lotto> issuedLottos) {
    }
}
