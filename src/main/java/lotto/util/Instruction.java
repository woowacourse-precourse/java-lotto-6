package lotto.util;

public enum Instruction {
    PRINT_INPUT_MONEY("구입금액을 입력해 주세요.");

    private final String message;

    Instruction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
