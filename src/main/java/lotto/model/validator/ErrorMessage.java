package lotto.model.validator;

// model.validator에서만 사용하는 에러메세지
enum ErrorMessage {
    NOT_PROPER_SIZE_OF_LOTTO("번호의 개수가 6개가 아닙니다."),
    NUMBER_NOT_IN_RANGE("올바른 범위의 수가 아닙니다."),
    HAS_DUPLICATED_NUMBER("중복 값이 존재합니다."),
    NULL_ENTERED("null 값이 입력됐습니다."),
    NOT_PROPER_OBJECT_TYPE("올바른 객체 타입이 아닙니다.");

    private static final String MESSAGE_HEADER = "[ERROR]";
    private static final String WHITE_SPACE = " ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_HEADER
                + WHITE_SPACE
                + message;
    }
}