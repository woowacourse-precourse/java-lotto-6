package lotto;

public enum InputMessage {

    INPUT_MONEY("구입금액을 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
