package lotto.util.constants;

public enum InputConstants {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_AMOUNT_REGEX("\\d+"),
    INPUT_WINNER_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_NUMERIC_ERROR("[ERROR] 구매금액은 숫자만 입력해주세요."),
    INPUT_UNIT_ERROR("[ERROR] 구매금액은 1000원 단위로 입력해주세요.");

    private final String string;

    InputConstants(String inputMessage) {
        this.string = inputMessage;
    }

    public String getInputMessage() {
        return string;
    }
}
