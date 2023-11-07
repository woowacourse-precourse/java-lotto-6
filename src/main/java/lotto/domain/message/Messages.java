package lotto.domain.message;

import java.util.List;
import java.util.stream.Collectors;

public enum Messages {

    INPUT_PURCHASE_CASH_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTERIES_FORMAT("\n%d개를 구매했습니다."),
    LOTTERIES_NUMBERS_FORMAT("[%s]"),
    LOTTERIES_NUMBERS_DELIMITER(", "),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_START("\n당첨 통계\n---"),
    WINNING_STATISTIC_INFORMATION_FORMAT("%d개 일치 (%d원) - %d개"),
    YIELD_FORMAT("총 수익률은 %s%입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int value) {
        return String.format(message, value);
    }

    public String getMessage(String value) {
        return String.format(message, value);
    }

    public String getMessage(List<Integer> values, String delimiter) {
        String content = values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
        return String.format(message, content);
    }

}
