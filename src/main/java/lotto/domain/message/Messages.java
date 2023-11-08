package lotto.domain.message;

import java.text.DecimalFormat;

public enum Messages {

    INPUT_PURCHASE_CASH_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_START("\n당첨 통계\n---"),
    YIELD_FORMAT("총 수익률은 %s%%입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String value) {
        return String.format(message, value);
    }

    public String getMessage(double yield) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedNumber = decimalFormat.format(yield);
        return YIELD_FORMAT.getMessage(formattedNumber);
    }

}
