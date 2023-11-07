package lotto;

public enum Error {
    INVALID_NUMBERS_SIZE("[ERROR] 로또 번호는 6개의 숫자가 들어와야 합니다. \n"),
    INVALID_NUMBERS_VALUE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n"),
    DUPLICATE_NUMBERS("[ERROR] 로또 번호가 중복 됩니다.\n");

    private String errMsg;

    Error(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }
}
