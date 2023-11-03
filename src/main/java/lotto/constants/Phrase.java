package lotto.constants;

public enum Phrase {
    INPUT_LOTTO_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    Phrase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
