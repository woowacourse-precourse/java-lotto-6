package lotto;

import java.util.List;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printErrorMessage(String message) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, message));
    }

    public void printGeneratedLotto(List<String> numbers) {
        System.out.println(String.format(LOTTO_COUNT_FORMAT, numbers.size()));
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public void printProfitRate(float profit) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profit));
    }
}
