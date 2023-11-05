package lotto.exception;

public interface ExceptionMessage {
    enum priceInputExceptionMessage {
        INPUT_MUST_NOT_CONTAINS_SPACE("[ERROR]] 공백없이 입력해주세요."),
        INPUT_MUST_BE_NUMERIC("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        INPUT_MUST_BE_1000s("[ERROR] 로또 가격은 1000원 단위로 입력해주세요.");

        public final String message;

        priceInputExceptionMessage(final String message) {
            this.message = message;
        }
    }
}
