package lotto;

public enum ExceptionMessage {
    NO_COMMA_EXCEPTION("[ERROR] 콤마(,)를 연속하여 입력할 수 없습니다."),
    NOT_RANGE_EXCEPTION("[ERROR] 당첨 번호는 1~45 사이의 숫자를 콤마(,)로 구분하여 입력해야 합니다."),
    NOT_PROPER_SIZE_EXCEPTION("[ERROR] 여섯자리의 숫자를 입력해야 합니다."),
    NOT_PROPER_DATA_TYPE_EXCEPTION("[Error] 숫자와 콤마(,) 이외의 값을 입력하셨습니다."),
    NOT_PROPER_BONUSNUMBER_RANGE("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다."),
    NOT_PROPER_PURCHASE_INPUT("[ERROR] 돈은 1000원 단위만 입력 가능합니다."),
    NOT_PROPER_PURCHASE_INPUT_DATA_TYPE("[ERROR] 구매 금액으로 숫자만 입력 가능합니다."),
    NOT_PROPER_LOTTO_NUMBER("[ERROR] 로또 번호는 여섯자리여야 합니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
