package lotto.model;

public class WinningLotto {
    private final int bonusNumber;
    private final Lotto winningLotto;

    public WinningLotto(Lotto lotto, String bonus) {
        winningLotto = lotto;
        validateBonusNumber(winningLotto, bonus);
        bonusNumber = Integer.parseInt(bonus);
    }

    private void validateBonusNumber(Lotto lotto, String bonus) {
        isInteger(bonus);
    }

    private void isInteger(String bonus) {
        if (!bonus.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 넘버는 숫자여야 합니다.");
        }
    }
}
