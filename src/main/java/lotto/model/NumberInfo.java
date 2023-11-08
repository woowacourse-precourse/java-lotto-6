package lotto.model;

import java.util.List;

public class NumberInfo {

    private final WinningNumber winningNumbersList;
    private final BonusNumber bonusNumber;

    public NumberInfo(WinningNumber winningNumbersList, BonusNumber bonusNumber){
        this.winningNumbersList = winningNumbersList;
        this.bonusNumber = bonusNumber;
    }
}
