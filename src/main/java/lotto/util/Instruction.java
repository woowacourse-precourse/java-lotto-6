package lotto.util;

public enum Instruction {
    PRINT_INPUT_MONEY("구입금액을 입력해 주세요."),
    ERROR_INPUT_MONEY("[ERROR] 구입 금액으로 1000 이상의 수를 입력해 주세요."),
    ERROR_MULTIPLE_MONEY("[ERROR] 구입 금액으로 1000의 배수를 입력해 주세요.");

    private final String message;

    Instruction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
