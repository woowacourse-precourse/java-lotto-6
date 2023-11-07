package lotto.constant.Message;

public enum ErrorMessage {
    IS_NULL_MESSAGE("입력값이 없습니다."),
    HAS_BLANK_MESSAGE("앞 뒤를 제외한 공백이 존재합니다"),
    IS_NOT_DIGIT_MESSAGE("숫자가 아닙니다."),
    IS_NOT_THOUSAND_UNIT_MESSAGE("천원 단위가 아닙니다."),
    IS_NOT_COMMA_SEPARATOR_MESSAGE("쉼표로 구분되어 있지 않습니다."),
    IS_NOT_SIX_THINGS_MESSAGE("6개를 입력해야합니다."),
    IS_NOT_ONE_THING_MESSAGE("1개를 입력해야합니다."),
    HAS_DUPLICATE_NUMBER_MESSAGE("중복값이 존재합니다.");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
