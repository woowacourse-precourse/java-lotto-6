package lotto.domain.lotto;

public class WinningCombination {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningCombination(Lotto winningNumbers, BonusNumber bonusNumber) {
        verifyBonusIsValid(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningCombination from(Lotto numbers, BonusNumber bonusNumber) {
        return new WinningCombination(numbers, bonusNumber);
    }

    private void verifyBonusIsValid(Lotto winningNumbers, BonusNumber bonusNumber) {
        if (hasBonusNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException("입력한 당첨번호와 동일한 숫자를 입력하면 안 됩니다.");
        }
    }

    public LottoRank getLottoRankOf(Lotto purchasedLotto) {
        int matchCount = matchNumbers(purchasedLotto);
        boolean hasBonusNumber = hasBonusNumber(winningNumbers, bonusNumber);
        return LottoRank.of(matchCount, hasBonusNumber);
    }

    private int matchNumbers(Lotto purchasedLotto) {
        int matchCount = 0;
        if (winningNumbers.contains(purchasedLotto)) {
            matchCount++;
        }
        return matchCount;
    }

    private boolean hasBonusNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        return bonusNumber.isMatching(winningNumbers);
    }
}


