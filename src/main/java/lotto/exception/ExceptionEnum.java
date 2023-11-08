package lotto.exception;

public enum ExceptionEnum {
    NOT_NUMBER_EXCEPTION("[ERROR] 숫자를 입력해주세요"),
    NOT_DIVIDED_EXCEPTION("[ERROR] 1,000원 단위로 입력해주세요"),
    NOT_IN_RANGE_EXCEPTION("[ERROR] 1~45 사이의 값을 입력해주세요"),
    CONTAIN_EMPTY_SPACE_EXCEPTION("[ERROR] 빈칸 없이 입력해주세요"),
    CONTAIN_DUPLICATE_NUMBER_EXCEPTION("[ERROR] 서로 다른 수를 입력해주세요"),
    CONTAIN_DUPLICATE_BONUS_NUMBER_EXCEPTION("[ERROR] 당첨 번호와 다른 수를 입력해주세요"),
    NOT_ENOUGH_NUMBER_EXCEPTION("[ERROR] 6개의 수를 입력해주세요");
    private final String message;

    ExceptionEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
