package lotto.constant;

public enum InputText {
    REQUEST_TO_INPUT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요.\n(1,000원 ~ 100,000원)"),
    REQUEST_TO_INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.\n(중복 되지 않는 1~45사이의 수 6개)"),
    REQUEST_TO_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n(당첨 번호와 중복되지 않는 1~45사이의 수 1개)"),
    ERROR_TAG("[ERROR]");

    private String value;

    InputText(String instruction) {
        this.value = instruction;
    }

    public String getValue() {
        return value;
    }
}
