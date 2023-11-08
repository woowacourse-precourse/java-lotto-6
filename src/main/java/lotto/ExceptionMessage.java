package lotto;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;

public enum ExceptionMessage {
    INVALID_AMOUNT("[ERROR]금액은 1000원으로 나누어 떨어져야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR]숫자를 입력해 주세요."),
    INPUT_NULL("공백이 입력되었습니다."),
    INPUT_NOT_SIX("6개의 숫자를 입력해주세요."),
    INPUT_DUPLICATED_NUMBER("중복된 숫자가 입력되었습니다."),
    INPUT_OUT_OF_ARRANGE("1부터 45사이의 숫자를 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessageText() {
        return message;
    }
}





