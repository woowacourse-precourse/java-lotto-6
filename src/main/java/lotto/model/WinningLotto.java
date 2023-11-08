package lotto.model;

import lotto.Lotto;

public class WinningLotto {
    private static final String BONUS_NUMBER_DOES_NOT_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 보너스 번호의 범위는 1 ~ 45까지 입니다.";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validate(Lotto winningLotto, int bonusNumber) {
        validateDuplicateCheck(winningLotto, bonusNumber);
        validateNumberRange(bonusNumber);
    }

    public static void validateDuplicateCheck(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DOES_NOT_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    public boolean isContain(int number){
        return winningLotto.isContain(number);
    }
}
