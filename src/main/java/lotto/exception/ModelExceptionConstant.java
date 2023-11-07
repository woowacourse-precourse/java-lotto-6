package lotto.exception;

import org.junit.jupiter.api.Test;

public enum ModelExceptionConstant {
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45사이의 숫자이어야 합니다.");

    private final String text;
    ModelExceptionConstant(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
