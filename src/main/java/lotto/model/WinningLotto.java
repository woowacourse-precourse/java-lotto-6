package lotto.model;

public class WinningLotto {
    private static final String BONUS_NUMBER_DOES_NOT_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
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
    }

    public static void validateDuplicateCheck(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DOES_NOT_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }

    public boolean isContain(int number){
        return winningLotto.isContain(number);
    }
}
