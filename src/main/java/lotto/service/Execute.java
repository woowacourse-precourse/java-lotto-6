package lotto.service;

import lotto.console.Input;
import lotto.domain.Asset;
import lotto.domain.Lotto;

public class Execute {
    public void start(){
        Asset asset = Input.askMoney();
        Lotto winningNum = Input.askWinningNum();
        Integer bonusNum = Input.askBonusNum();

        
    }
}
