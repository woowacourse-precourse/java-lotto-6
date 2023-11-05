package lotto.view;

public enum InputViewConstants {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_AMOUNT_REGEX("\\d+"),
    INPUT_NUMERIC_ERROR("[ERROR] 구매금액은 숫자만 입력해주세요."),
    INPUT_UNIT_ERROR("[ERROR] 구매금액은 숫자만 입력해주세요.");


    private final String inputMessage;
    InputViewConstants(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
