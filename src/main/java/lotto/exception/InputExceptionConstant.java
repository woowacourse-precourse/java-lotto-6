package lotto.exception;

import java.awt.TextArea;

public enum InputExceptionConstant {
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45사이의 숫자이어야 합니다."),
    NO_BLANK_IN_STRING("[ERROR] 입력 문자열에 공백이 포함되어서는 안됩니다."),
    ONLY_NATURAL_NUMBER_IN_STRING_ARRAY("[ERROR] 당첨 숫자는 자연수로만 이루어져야 합니다."),
    ONLY_NATURAL_NUMBER_IN_STRING("[ERROR] 입력 값은 자연수로만 이루어져야 합니다.");

    private final String text;
    InputExceptionConstant(String errText) {
        this.text = errText;
    }

    public String getText() {
        return this.text;
    }
}
