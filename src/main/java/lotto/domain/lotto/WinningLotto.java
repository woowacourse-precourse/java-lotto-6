package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
        validate(winningNumbers, bonusNumber);
    }

    public static WinningLotto of(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public LottoPrize matches(Lotto lotto) {
        int matchCount = lotto.getMatchCount(this.numbers);
        boolean isBonusMatched = lotto.isBonusMatched(bonusNumber);
        return LottoPrize.findLottoPrize(matchCount, isBonusMatched);
    }

    protected void validate(List<Integer> numbers, BonusNumber bonusNumber) {
        validateNoDuplicatedWinningNumbers(numbers, bonusNumber);
    }

    private void validateNoDuplicatedWinningNumbers(List<Integer> winningNumbers,
        BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumbers)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복입니다.");
        }
    }
}
