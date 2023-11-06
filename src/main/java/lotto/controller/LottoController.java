package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmountofMoney;
import lotto.view.DisplayInput;
import lotto.view.DisplayOutput;

public class LottoController {

    private final DisplayOutput displayOutput = new DisplayOutput();
    private final DisplayInput displayInput = new DisplayInput();

    public void play(){
        LottoAmountofMoney lottoAmountofMoney = new LottoAmountofMoney(getLottoAmountofMoney());
        Lotto answerLotto = new Lotto(getAnswerLottoNumber());
    }
    private Integer getLottoAmountofMoney(){
        return displayInput.inputLottoAmountofMoney();
    }

    private List<Integer> getAnswerLottoNumber(){
        List<Integer> lottoNumbers = new ArrayList<>();
        String inputtedLottoNumbers = displayInput.inputLottoNumbers();
        String[] inputtedlottoNumberList = inputtedLottoNumbers.split(",");
        for(String lottoNumber : inputtedlottoNumberList){
            lottoNumbers.add(Integer.parseInt(lottoNumber));
        }
        return lottoNumbers;
    }


}
