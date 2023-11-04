package lotto.view;

public enum InputMessage {

    INPUT_LOTTO("로또 번호에 중복이 있습니다"),
    INPUT_BONUS_NUMBER("로또 번호의 개수가 맞지 않습니다"),
    INPUT_PURCHASE_AMOUNT("로또 번호의 범위가 맞지 않습니다"),
    ;

    private final String message;

    public String getMessage() {
        return message;
    }

    InputMessage(String message) {
        this.message = message;
    }

}
