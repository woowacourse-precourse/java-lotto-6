package lotto.exception;

public interface ExceptionMessage {
    enum LottoException {
        LOTTO_SIZE_IS_NOT_FULFILL("구매한 로또는 총 6개의 번호가 기입되어야 합니다."),
        LOTTO_NUMBER_IS_NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        LOTTO_NUMBER_MUST_BE_UNIQUE("중복된 번호는 허용하지 않습니다."),
        BONUS_NUMBER_IS_NOT_IN_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        ;

        public final String message;

        LottoException(final String message) {
            this.message = message;
        }
    }

    enum LottoMachineException {
        BONUS_NUMBER_MUST_BE_UNIQUE("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
        ;

        public final String message;

        LottoMachineException(final String message) {
            this.message = message;
        }
    }
}
