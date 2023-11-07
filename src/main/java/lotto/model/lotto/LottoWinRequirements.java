package lotto.model.lotto;

import java.util.List;

public class LottoWinRequirements {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    private LottoWinRequirements(List<Integer> winningNumber, int bonusNumber) {
        checkDuplicateNumbers(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinRequirements of(List<Integer> winningNumber, int bonusNumber) {
        return new LottoWinRequirements(winningNumber, bonusNumber);
    }

    private static void checkDuplicateNumbers(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 중복됩니다.");
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
