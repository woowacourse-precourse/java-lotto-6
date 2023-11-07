package lotto.constants;

public enum StaticMessage {
    PRINT_LOTTO_COUNT("개를 구매했습니다."),
    PRINT_RESULT_NOTICE("당첨 통계%n---");

    private final String message;
    StaticMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
