package lotto.Model;

public class CompareResult {

    private final Lotto lotto;
    private final int bonusNumber;

    public CompareResult(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult compareNumbers(Lotto purchasedLotto) {
        int matchCount = purchasedLotto.countMatchNumber(lotto);
        boolean bonusNumberCheck = purchasedLotto.contains(bonusNumber);

        return WinningResult.setResult(matchCount, bonusNumberCheck);
    }
}
