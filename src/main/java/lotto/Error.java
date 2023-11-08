package lotto;

public enum Error {
    INVALID_NUMBERS_SIZE("[ERROR] 로또 번호는 6개의 숫자가 들어와야 합니다. \n"),
    INVALID_NUMBERS_VALUE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n"),
    DUPLICATE_NUMBERS("[ERROR] 로또 번호가 중복 됩니다.\n"),
    INPUT_ERROR("[ERROR] 입력 값을 확인해주세요.\n"),
    UNDIVIDED_PURCHASE_AMOUNT("[ERROR] 입력 금액은 1000으로 나누어져야 합니다.\n"),
    NOT_INTEGER_VALUE("[ERROR] 입력 값이 정수가 아닙니다.\n")
    ;

    private final String errMsg;

    Error(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }
}
