package lotto.domain.lotto.exception;

public final class DuplicateBonusNumberException extends IllegalArgumentException {
    public static final String DUPLICATE_BONUS_NUMBER_EXCEPTION = "보너스 번호가 로또 번호와 중복됩니다.";

    public DuplicateBonusNumberException() {
        super(DUPLICATE_BONUS_NUMBER_EXCEPTION);
    }
}
