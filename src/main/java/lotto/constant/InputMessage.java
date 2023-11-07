package lotto.constant;

public enum InputMessage {
    RECEIVE_LOTTO_NUMBER("당첨 번호를 입력해 주세요"),
    RECEIVE_BONUS_NUMBER("보너스 번호를 입력해주세요"),
    RECEIVE_MONEY("구입금액을 입력해 주세요");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
