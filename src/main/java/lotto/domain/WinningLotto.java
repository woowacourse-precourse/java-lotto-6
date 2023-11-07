package lotto.domain;

public class WinningLotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "보너스 숫자는 당첨 번호와 중복될 수 없습니다";
    private static final String BONUS_NUMBER_WRONG_RANGE_EXCEPTION_MESSAGE = "보너스 숫자가 1에서 45 사이의 범위를 벗어납니다";

    private final Lotto answerLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto answerLotto, int bonusNumber) {
        this.answerLotto = answerLotto;
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(int bonusNumber) {
        validateCorrectRange(bonusNumber);
        validateDuplicateNumber(bonusNumber);
    }

    private void validateDuplicateNumber(int bonusNumber) {
        if (answerLotto.getNumbers()
                .stream()
                .anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void validateCorrectRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_WRONG_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public Lotto getAnswerLotto() {
        return answerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
