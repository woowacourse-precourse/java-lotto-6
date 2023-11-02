package lotto.exception;

public interface ExceptionMessage {
    enum LottoException {
        LOTTO_SIZE_IS_NOT_FULFILL("구매한 로또는 총 6개의 번호가 기입되어야 합니다."),
        LOTTO_NUMBER_IS_NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        LOTTO_NUMBER_MUST_BE_UNIQUE("중복된 번호는 허용하지 않습니다."),
        BONUS_NUMBER_IS_NOT_IN_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
        BONUS_NUMBER_MUST_BE_UNIQUE("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
        ;

        public final String message;

        LottoException(final String message) {
            this.message = message;
        }
    }

    enum InputException {
        INPUT_MUST_NOT_CONTAINS_SPACE("공백없이 입력해주세요."),
        INPUT_MUST_BE_NUMERIC("숫자를 입력해주세요."),
        PURCHASE_AMOUNT_MUST_BE_POSITIVE("구입 금액은 음수가 될 수 없습니다."),
        PURCHASE_AMOUNT_MUST_MEET_SPECIFIC_UNIT("1000원 단위로 구입금액을 입력해주세요."),
        WINNING_NUMBER_MUST_BE_SPLIT_BY_COMMA("당첨번호는 쉼표(,)로 구분해서 공백없이 입력해주세요."),
        ;

        public final String message;

        InputException(final String message) {
            this.message = message;
        }
    }
}
