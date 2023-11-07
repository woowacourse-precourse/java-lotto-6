package lotto.model.domain;

import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.WinNumber;

public class LottoWinNumber {

    private WinNumber winNumber;
    private BonusNumber bonusNumber;

    private LottoWinNumber(WinNumber winNumber, BonusNumber bonusNumber) {
        validateDuplication(winNumber, bonusNumber);
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinNumber from(WinNumber winNumber, BonusNumber bonusNumber) {
        return new LottoWinNumber(winNumber, bonusNumber);
    }

    private void validateDuplication(WinNumber winNumber, BonusNumber bonusNumber) {
        if (isDuplicatedBetweenWinAndBonus(winNumber, bonusNumber)) {
            throw new IllegalArgumentException("당첨 숫자와 보너스 숫자가 중복하면 안됩니다.");
        }
    }

    private boolean isDuplicatedBetweenWinAndBonus(WinNumber winNumber, BonusNumber bonusNumber) {
        return winNumber.getWinNumber().stream()
                .anyMatch((w) -> w.equals(bonusNumber.getBonusNumber()));
    }
}
