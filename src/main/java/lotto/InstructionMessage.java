package lotto;

public enum InstructionMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PRINT_LOTTO_COUNT("개를 구매했습니다.");

    private final String message;

    InstructionMessage(String message) {
        this.message = message;
    }

    public String getMessageText() {
        return message;
    }
}
