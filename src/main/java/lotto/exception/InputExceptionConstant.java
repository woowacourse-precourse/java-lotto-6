package lotto.exception;

public enum InputExceptionConstant {
    NO_BLANK_IN_STRING("[ERROR] 입력 문자열에 공백이 포함되어서는 안됩니다."),
    ONLY_NATURAL_NUMBER_IN_STRING_ARRAY("[ERROR] 당첨 숫자는 자연수로만 이루어져야 합니다."),
    ONLY_NATURAL_NUMBER_IN_STRING("[ERROR] 입력 값은 자연수로만 이루어져야 합니다.");

    private final String text;

    InputExceptionConstant(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
