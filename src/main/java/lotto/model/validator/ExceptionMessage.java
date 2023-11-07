package lotto.model.validator;

public enum ExceptionMessage {
    START_MESSAGE("[ERROR] "),

    PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000("1000원 단위로 구입하실 수 있습니다."),
    LOTTO_INCLUDE_6_NUMBERS("로또 번호는 6가지 숫자로 이뤄져있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return START_MESSAGE.message + message;
    }
}
