package lotto.message;

public enum Message {
    ASK_PURCHASING_PRICE("구입금액을 입력해 주세요."),
    QUANTITY_OF_LOTTO("개를 구매했습니다. "),
    EXECUTION_RESULT_TITLE(""),
    WINNER("최종 우승자 : "),

    NAME_LENGTH_ERROR("자동차 이름은 5자 이하까지만 가능합니다.");


    private String message;

    Message(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}