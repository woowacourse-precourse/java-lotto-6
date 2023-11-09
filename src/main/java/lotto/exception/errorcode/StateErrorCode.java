package lotto.exception.errorcode;

public enum StateErrorCode {
    FAIL_PARSE_LONG_TO_INT("long 자료형을 int로 바꾸는데 실패하였습니다."),
    FAIL_GET_VALUE_FROM_COLLECTION("컬렉션에서 원소를 가져오는데 실패하였습니다.");

    private final String message;

    StateErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
