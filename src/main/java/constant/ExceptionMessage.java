package constant;

import java.text.DecimalFormat;

public enum ExceptionMessage {
    INCORRECT_COUNT_OF_WINNING_NUMBERS("당첨 번호는 6개여야 합니다."),
    NON_NUMERIC_INPUT("숫자가 입력되어야 합니다."),
    DUPLICATE_WINNING_NUMBERS("당첨 번호는 중복되지 않아야 합니다."),
    LESS_MONEY_THAN_THE_TICKET_PRICE(String.format("로또 티켓 가격(%s원) 이상이 필요합니다.",
            new DecimalFormat("###,###")
                    .format(ConstantNumber.LOTTO_TICKET_COST.get())
    )),
    INPUT_OTHER_THAN_PRICE_UNIT(String.format("구입 금액은 로또 티켓 가격(%s원) 단위로 주어져야 합니다.",
            new DecimalFormat("###,###")
                    .format(ConstantNumber.LOTTO_TICKET_COST.get())
    )),
    MONEY_AMOUNT_IS_NEGATIVE("구입 금액이 0원 이하입니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String get() {
        return "[ERROR] " + message;
    }
}
