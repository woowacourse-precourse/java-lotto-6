package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidate;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private final InputValidate inputValidate = new InputValidate();
    private OutputView outputView = new OutputView();

    private String userInput(){
        return Console.readLine();
    }

    public int inputBonus(){
        outputView.printBonusInputMessage();
        String input = userInput();
        inputValidate.inputBonusRangeValidate(input);
        int bonus = Integer.parseInt(input);
        return bonus;
    }

    public List<Integer> inputLotto(){
        outputView.printLottoInputMessage();
        List<Integer> lotto = new ArrayList<>();
        String[] input = userInput().split(",");
        for(String num : input){
            inputValidate.inputBlankValidate(num);
            inputValidate.inputIsDigitValidate(num);
            int lottoNum = Integer.parseInt(num);
            lotto.add(lottoNum);
        }
        return lotto;
    }

    public int inputMoney(){
        outputView.printMoneyInputMessage();
        String input = userInput();
        inputValidate.inputBlankValidate(input);
        inputValidate.inputIsDigitValidate(input);
        return Integer.parseInt(input);
    }
}
