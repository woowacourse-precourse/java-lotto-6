package lotto.domain;


import static lotto.exception.ExceptionMessage.OVERLAP_BONUS_NUMBER;


import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        super.numbers = winningNumbers;
        validateDuplicateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoNumber bonusNumber) {
        if (hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(OVERLAP_BONUS_NUMBER.getMessage());
        }
    }

    public Rank calculateRank(Lotto userLotto) {
        int sameNumberCount = super.countSameNumber(userLotto);
        boolean isBonus = hasBonusNumber(userLotto);
        return Rank.getRank(sameNumberCount, isBonus);
    }

    public boolean hasBonusNumber(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
