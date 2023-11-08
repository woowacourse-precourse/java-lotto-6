package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private OutputView() {

    }

    public static void printLottoPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLineSeparator() {
        System.out.println();
    }

    public static void printBuyLottoResultMessage(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getLottoPrintMessage()));
        printLineSeparator();
    }

    public static void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printRewardMessage(List<String> messages) {
        System.out.println("당첨 통계");
        System.out.println("---");
        messages.forEach(System.out::println);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
}
