package lotto.exception;

public enum ExceptionEnum {
    NOT_NUMBER_EXCEPTION("[Error] 숫자를 입력해주세요"),
    NOT_DIVIDED_EXCEPTION("[Error] 1,000원 단위로 입력해주세요"),
    NOT_IN_RANGE_EXCEPTION("[error] 1~45 사이의 값을 입력해주세요"),
    CONTAIN_EMPTY_SPACE_EXCEPTION("[error] 빈칸 없이 입력해주세요"),
    CONTAIN_DUPLICATE_NUMBER_EXCEPTION("[error] 서로 다른 수를 입력해주세요"),
    NOT_ENOUGH_NUMBER_EXCEPTION("[error] 6개의 수를 입력해주세요");
    private final String message;

    ExceptionEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
