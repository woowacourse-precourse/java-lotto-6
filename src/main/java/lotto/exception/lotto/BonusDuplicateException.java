package lotto.exception.lotto;

public class BonusDuplicateException extends IllegalArgumentException {
    private static final String DUPLICATE_BONUS_NUMBER_MSG = "보너스 번호는 로또와 다른 번호로 입력해주세요.";

    public BonusDuplicateException() {
        super(DUPLICATE_BONUS_NUMBER_MSG);
    }
}
