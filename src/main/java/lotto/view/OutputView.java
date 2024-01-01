package lotto.view;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.repository.Result;

public class OutputView {

    public static void printNumberOfLottoTickets(Money money) {
        System.out.printf("%d개를 구매했습니다.\n", money.numberOfLottoTickets());
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }

    public static void printRandomLottoTicket(Lottos Lottos) {
        System.out.println(Lottos);
    }

    public static void printRateOfReturn(Money money, Result result) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.rateOfReturn(money));
    }

    public static void printError(IllegalArgumentException e) {
        System.out.printf("[ERROR] %s\n", e.getMessage());
    }
}
