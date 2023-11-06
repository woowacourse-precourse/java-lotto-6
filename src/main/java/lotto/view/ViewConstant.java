package lotto.view;

public enum ViewConstant {

    ASK_PAYMENT_MESSAGE("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_NUMBER_DELIMITER(","),
    NUMBER_PATTERN("\\d+"),
    WINNING_NUMBER_PATTERN("([\\d]+[,])*[\\d]");

    private final String value;

    ViewConstant(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
