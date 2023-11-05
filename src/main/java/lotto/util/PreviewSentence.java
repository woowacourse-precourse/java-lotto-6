package lotto.util;

public enum PreviewSentence {
    INPUT_MONEY("구입금액을 입력해주세요.");

    private final String message;

    PreviewSentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
