package lotto.utils;

public enum ErrorMessage {
    INPUT_IS_EMPTY("입력된 값이 없습니다!"),
    NON_INTEGER_VALUE("입력된 예산이 정수가 아닙니다!"),
    ONLY_ZERO_OR_MORE("예산은 0 이상의 수만 입력될 수 있습니다!"),
    UNITS_OF_1000("입력된 예산이 1000원 단위가 아닙니다!"),
    DUPLICATED_VALUES("로또 번호가 중복됩니다!")
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
