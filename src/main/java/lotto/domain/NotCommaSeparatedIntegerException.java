package lotto.domain;

public class NotCommaSeparatedIntegerException extends IllegalArgumentException {
    public NotCommaSeparatedIntegerException() {
        super("[ERROR] 숫자와 쉼표(,)만 입력해야 합니다.\n");
    }
}

