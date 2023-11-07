package lotto.model.service;

import lotto.controller.dto.NumberDto;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.WinNumber;

public class LottoHeadQuarter {

    public LottoHeadQuarter() {
    }

    public NumberDto pickWinNumber(WinNumber winNumber, BonusNumber bonusNumber) {
        validateDuplication(winNumber, bonusNumber);
        return NumberDto.toDto(winNumber, bonusNumber);
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

    public void drawWinner() {

    }

    public void calculateReturn() {

    }

    public void publishResult() {
        
    }
}
