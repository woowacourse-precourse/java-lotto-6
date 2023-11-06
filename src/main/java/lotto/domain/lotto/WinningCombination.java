package lotto.domain.lotto;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class WinningCombination {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningCombination(Lotto winningNumbers, BonusNumber bonusNumber) {
        LottoValidator.verifyBonusIsNotContainWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningCombination of(Lotto numbers, BonusNumber bonusNumber) {
        return new WinningCombination(numbers, bonusNumber);
    }

    public LottoRank getLottoRankFrom(Lotto purchasedLotto) {
        int matchCount = countMatchingNumbers(purchasedLotto);
        boolean hasBonusNumber = hasBonusNumber(winningNumbers, bonusNumber);
        return LottoRank.of(matchCount, hasBonusNumber);
    }

    private int countMatchingNumbers(Lotto purchasedLotto) {
        return (int) purchasedLotto.getLottoNumbers()
                .stream()
                .filter(winningNumbers.getLottoNumbers()::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = winningNumbers.getLottoNumbers();
        return lottoNumbers.contains(bonusNumber.getBonusNumber());
    }
}


