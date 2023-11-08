package Input;

public enum InputMessage {
    GET_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PRICE_ERROR_MESSAGE("[ERROR] 1000원 단위의 가격을 입력해주세요"),
    GET_ANSWER_LOTTO("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
