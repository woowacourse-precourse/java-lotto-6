package lotto.domain.lotto;

import static lotto.io.ErrorMessage.DUPLICATE_BONUS_NUMBER;

public class WinningNumber {
    private final Lotto drawNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto lotto, BonusNumber bonusNumber) {
        validateUniqueNumbers(lotto, bonusNumber);
        this.drawNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateUniqueNumbers(Lotto lotto, BonusNumber bonusNumber) {
        for (Integer num : lotto.getNumbers()) {
            if (bonusNumber.getNumber() == num) {
                throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
            }
        }
    }

    public LottoResult compare(Lotto lotto) {
        int hitCount = drawNumbers.getHitCount(lotto);
        boolean hasBonus = checkBonusHit(lotto, hitCount);

        return LottoResult.of(hitCount, hasBonus);
    }

    private boolean checkBonusHit(Lotto lotto, int hitCount) {
        return lotto.isContainNumber(bonusNumber.getNumber()) && hitCount <= 5;
    }

}
