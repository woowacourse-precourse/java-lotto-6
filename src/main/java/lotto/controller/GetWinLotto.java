package lotto.controller;

import lotto.Lotto;
import lotto.model.WinLotto;


public interface GetWinLotto {

    WinLotto getWinLotto();


    Lotto getWinNumber();

    Integer getBonusNumber(Lotto winNumber);

    Lotto validWinNumber(String winNumbers);

    int validBonusNumber(String bonusNumber,Lotto winLotto);

}
