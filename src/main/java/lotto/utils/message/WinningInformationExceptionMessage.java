package lotto.utils.message;

public enum WinningInformationExceptionMessage {
    BLANK_WINNING_NUMBER("[ERROR] 당첨 번호를 입력해 주세요."),
    EXCEED_LENGTH("[ERROR] 당첨 번호는 20 자리 이내로 입력해야 합니다."),
    FIRST_CHARACTER_COMMA("[ERROR] 콤마(,)는 첫 문자로 올 수 없습니다."),
    LAST_CHARACTER_COMMA("[ERROR] 콤마(,)는 마지막 문자로 올 수 없습니다."),
    NOT_NUMERIC("[ERROR] 당첨 번호는 숫자로만 입력해야 합니다."),
    OUT_OF_RANGE("[ERROR] 당첨 번호는 1 ~ 45 범위의 수만 가능 합니다."),
    DUPLICATE_EXISTS("[ERROR] 중복된 당첨 번호가 존재합니다."),
    INVALID_COUNT("[ERROR] 당첨 번호는 6개여야 합니다.");

    private final String error;

    WinningInformationExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
