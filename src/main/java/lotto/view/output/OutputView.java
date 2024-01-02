package lotto.view.output;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.repository.Result;

public class OutputView {

    public static void printNumberOfLotto(Money money) {
        System.out.printf("%d개를 구매했습니다.\n", money.numberOfLotto());
    }

    public static void printResult(Result result) {
        System.out.println(result);
    }

    public static void printRandomLotto(List<Lotto> randomLotto) {
        randomLotto.forEach(System.out::println);
    }

    public static void printRateOfReturn(Money money, Result result) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.rateOfReturn(money));
    }

    public static void printError(IllegalArgumentException e) {
        System.out.printf("[ERROR] %s\n", e.getMessage());
    }
}
