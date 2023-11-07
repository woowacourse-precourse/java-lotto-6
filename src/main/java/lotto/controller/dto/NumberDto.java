package lotto.controller.dto;

import lotto.model.domain.vo.BonusNumber;
import lotto.model.domain.vo.WinNumber;

public class NumberDto {

    private WinNumber winNumber;
    private BonusNumber bonusNumber;

    private NumberDto(WinNumber winNumber, BonusNumber bonusNumber) {
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public static NumberDto toDto(WinNumber winNumber, BonusNumber bonusNumber) {
        return new NumberDto(winNumber, bonusNumber);
    }
}
