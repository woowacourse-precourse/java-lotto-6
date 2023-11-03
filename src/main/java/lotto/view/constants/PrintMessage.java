package lotto.view.constants;

public enum PrintMessage {
    PRINT_GAME_START("구입 금액을 입력해주세요.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
