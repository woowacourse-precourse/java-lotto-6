package lotto.utils;

public enum ExceptionMessage {

    NOT_NUMBER("[ERROR]숫자를 입력하세요."),
    NON_DIVISIBLE_BY_1000("[ERROR]1000으로 나누어 떨어지지 않습니다."),
    OUTSIDE_RANGE("[ERROR]입력 범위를 벗어났습니다."),
    NON_COMMA("[ERROR]쉼표로 구분해주세요."),
    EXCEEDS_LENGTH("[ERROR]입력을 초과했습니다."),
    DUPLICATE_INPUT("[ERROR]입력이 중복되었습니다."),
    UNDER_LENGTH("[ERROR]숫자 6개 입력하세요."),
    DELETE_COMMA("[ERROR]필요하지 않은 콤마는 지워주세요.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
