package lotto.model;

import lotto.model.vo.BonusNumber;
import lotto.model.vo.WinNumber;

public class LottoHeadQuarter {

    private Player player;
    private WinNumber winNumber;
    private BonusNumber bonusNumber;

    public LottoHeadQuarter() {
    }

    public void pickWinNumber(WinNumber winNumber, BonusNumber bonusNumber) {
        validateDuplication(winNumber, bonusNumber);
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
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
