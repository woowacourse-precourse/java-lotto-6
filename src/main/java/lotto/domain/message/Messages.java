package lotto.domain.message;

import java.text.DecimalFormat;

public enum Messages {

    INPUT_PURCHASE_CASH_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_START("\n당첨 통계\n---");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
