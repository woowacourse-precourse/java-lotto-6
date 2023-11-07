package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.model.BounsNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmountofMoney;
import lotto.model.LottoChecker;
import lotto.model.RandomLottos;
import lotto.view.DisplayInput;
import lotto.view.DisplayOutput;

public class LottoController {

    private final DisplayOutput displayOutput = new DisplayOutput();
    private final DisplayInput displayInput = new DisplayInput();

    private final String DELIMETER = ",";

    public void play() {
        LottoAmountofMoney lottoAmountofMoney = new LottoAmountofMoney(getLottoAmountofMoney());
        RandomLottos randomLottos = getRandomLottos(lottoAmountofMoney);
        Lotto answerLotto = new Lotto(getAnswerLottoNumber());
        BounsNumber bounsNumber = new BounsNumber(getBonusNumber());
        LottoChecker lottoChecker = new LottoChecker(randomLottos,answerLotto, bounsNumber);
        HashMap<String, Integer> winningStatics = getWinningStatics(lottoChecker);
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
    private RandomLottos getRandomLottos(LottoAmountofMoney lottoAmountofMoney){
        RandomLottos randomLottos = new RandomLottos(lottoAmountofMoney);
        displayOutput.outputRandomLottos(randomLottos);
        return randomLottos;
    }
    private HashMap<String, Integer> getWinningStatics(LottoChecker lottoChecker){
        HashMap<String, Integer> winningStatics =  lottoChecker.checkLottoNumbers();
        displayOutput.outputWinningStatics(winningStatics);
        return winningStatics;
    }


}
