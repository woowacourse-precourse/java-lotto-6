package lotto.exception;

import lotto.domain.LottoRule;

public enum ExceptionMessage {
    LOTTO_INVALID_LENGTH("로또 번호의 길이는 " + LottoRule.LENGTH + "자리 입니다."),
    LOTTO_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_OUT_OF_RANGE("로또 번호는 " + LottoRule.MIN_RANGE +  "~" + LottoRule.MAX_RANGE + " 사이 숫자 입니다.");

    private static final String prefix = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = prefix + message;
    }
    public String getMessage() {
        return message;
    }

    public void throwException(){
        throw new IllegalArgumentException(message);
    }
}
