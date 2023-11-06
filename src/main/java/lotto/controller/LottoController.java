package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoAmountofMoney;
import lotto.view.DisplayInput;
import lotto.view.DisplayOutput;

public class LottoController {

    private final DisplayOutput displayOutput = new DisplayOutput();
    private final DisplayInput displayInput = new DisplayInput();

    public void play(){
        LottoAmountofMoney lottoAmountofMoney = new LottoAmountofMoney(getLottoAmountofMoney());

    }
    private Integer getLottoAmountofMoney(){
        return displayInput.inputLottoAmountofMoney();
    }


}
