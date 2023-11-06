package lotto.model;

public enum Message {
    ASK_MONEY("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
