package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Result;

public class OutputView {
    private static Integer PRICE=1000;
    public static void moneyMessage() {
        System.out.println(Message.MONEY.getMessage());
    }

    public static void buyComplete(Integer money) {
        System.out.printf("\n%d개를 구매했습니다.\n",money/PRICE);
    }

    public static void printLotto(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.toString());
    }

    public static void winningMessage() {
        System.out.println(Message.WINNING_NUM.getMessage());
    }

    public static void bonusMessage() {
        System.out.println(Message.BONUS_NUM.getMessage());
    }

    public static void resultMessage(Result result,Integer money) {
        System.out.println(Message.RESULT.getMessage());


        System.out.printf("%d개 일치 (%s원) - %d개\n", 3, "5,000", result.getCount(5));
        System.out.printf("%d개 일치 (%s원) - %d개\n", 4, "50,000", result.getCount(4));
        System.out.printf("%d개 일치 (%s원) - %d개\n", 5, "1,500,000", result.getCount(3));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", 5, "30,000,000", result.getCount(2));
        System.out.printf("%d개 일치 (%s원) - %d개\n", 6, "2,000,000,000", result.getCount(1));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.getProfitPercentage(money));
    }
    public static void errorMessage(String message) {
        System.out.printf("[ERROR] %s\n",message);
    }
}
