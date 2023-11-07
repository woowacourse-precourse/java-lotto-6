package lotto.message;

public enum ConsoleMessage {


    //Input Message
    GET_PURCHASE_MONEY("구입금액을 입력해 주세요."),

    //Error Message
    ERROR_STRING("[ERROR] "),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 넘버는 중복이 될 수 없습니다."),
    PURCHASE_MONEY_ERROR("로또 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
    private ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    private String message;
}
