package lotto.domain.message;

public enum InputMessage {

    INPUT_MONEY_NOTICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_NOTICE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_NOTICE("보너스 번호를 입력해 주세요."),
    INPUT_DELIMITER(",");

    private final String value;

    InputMessage(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
