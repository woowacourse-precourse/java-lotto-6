package lotto.exception;

public interface ExceptionMessage {
    enum LottoException {
        LOTTO_SIZE_IS_NOT_FULFILL("구매한 로또는 총 6개의 번호가 기입되어야 합니다."),
        ;

        public final String message;

        LottoException(final String message) {
            this.message = message;
        }
    }
}
