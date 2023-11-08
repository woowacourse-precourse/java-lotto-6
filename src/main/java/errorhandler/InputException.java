package errorhandler;

public enum InputException {
    RANGE_OF_NUMBER_EXCEPTION("[ERROR] 숫자의 범위는 1부터 45 사ㅇ이입니다."),
    NUMBERS_LENGTH_EXCEPTION("[ERROR] 숫자의 갯수는 6개 입니다."),
    DUPLE_NUMBER_EXCEPTION("[ERROR] 중복된 숫자를 입력하셨습니다. "),
    WRONG_MONEY("[ERROR] 복권은 천 원 단위로 구매하실 수 있습니다. ");
    String errorMessage;

    InputException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
