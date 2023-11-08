package lotto.controller;

import lotto.Lotto;
import lotto.message.ErrorMessage;
import lotto.model.WinLotto;

import java.util.ArrayList;
import java.util.List;

public interface GetWinLotto {

    public WinLotto getWinLotto();


    public Lotto getWinNumber();

    public Integer getBonusNumber(Lotto winNumber);

    public Lotto validWinNumber(String winNumbers);

    public int validBonusNumber(String bonusNumber,Lotto winLotto);

}
