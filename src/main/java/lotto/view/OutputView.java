package lotto.view;

import lotto.dto.PurchaseResult;
import lotto.model.Lotto;
import lotto.type.WinningType;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private static final String READ_CASH_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printReadCashMessage() {
        System.out.println(READ_CASH_PROMPT_MESSAGE);
    }

    public static void printPurchaseResult(PurchaseResult purchaseResult) {
        printLottoNumber(purchaseResult.getQuantity());
        printLottos(purchaseResult.getLottos());
    }

    private static void printLottoNumber(int number) {
        System.out.printf("%d개를 구매했습니다.\n", number);
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printReadWinningNumberMessage() {
        System.out.println(READ_WINNING_NUMBER);
    }
    
    public static void printReadBonusNumberMessage() {
        System.out.println(READ_BONUS_NUMBER);
    }

    public static void printWinningStatistic(List<Integer> statistic) {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");

        System.out.print("당첨 통계\n" + "---\n");

        int winningTypeIndex = 0;
        for (WinningType winningType : WinningType.values()) {
            System.out.printf("%s (%s원) - %d개\n",
                    winningType.getTitle(),
                    formatter.format(winningType.getMoney()),
                    statistic.get(winningTypeIndex));
            winningTypeIndex++;
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %2.1f%%입니다.", yield);
    }

}
