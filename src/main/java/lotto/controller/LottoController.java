package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BounsNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmountofMoney;
import lotto.view.DisplayInput;
import lotto.view.DisplayOutput;

public class LottoController {

    private final DisplayOutput displayOutput = new DisplayOutput();
    private final DisplayInput displayInput = new DisplayInput();

    private final String DELIMETER = ",";

    public void play() {
        LottoAmountofMoney lottoAmountofMoney = new LottoAmountofMoney(getLottoAmountofMoney());
        Lotto answerLotto = new Lotto(getAnswerLottoNumber());
        BounsNumber bounsNumber = new BounsNumber(getBonusNumber());
    }

    private Integer getLottoAmountofMoney() {
        displayOutput.outputLottoAmountofMoney();
        return displayInput.inputLottoAmountofMoney();
    }

    private List<Integer> getAnswerLottoNumber() {
        displayOutput.outputAnswerLotto();
        List<Integer> lottoNumbers = new ArrayList<>();
        String inputtedLottoNumbers = displayInput.inputLottoNumbers();
        String[] inputtedlottoNumberList = inputtedLottoNumbers.split(DELIMETER);
        for (String lottoNumber : inputtedlottoNumberList) {
            lottoNumbers.add(Integer.parseInt(lottoNumber));
        }
        return lottoNumbers;
    }

    private Integer getBonusNumber() {
        displayOutput.outputBonusNumber();
        return displayInput.inputBonusNumber();
    }


}
