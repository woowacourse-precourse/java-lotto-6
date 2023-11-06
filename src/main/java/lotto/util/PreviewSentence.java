package lotto.util;

public enum PreviewSentence {
    INPUT_MONEY("구입금액을 입력해주세요."),
    SAY_LOTTO_COUNT("%d개를 구매했습니다."),
    LINE_SEPARATOR("\n");

    private final String message;

    PreviewSentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int count) {
        return String.format(getMessage(), count);
    }
}
