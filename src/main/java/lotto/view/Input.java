package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputData;
import lotto.validator.BonusValidation;
import lotto.validator.MoneyValidation;
import lotto.validator.WinNumberValidation;

import java.util.Comparator;
import java.util.List;

public class Input {

    static List<String> lottolist;
    public String readMoney(){
        String input = Console.readLine();
        checkNumberValidator(input);
        return input;
    }

    public List<String> inputWinNumber(){
        String input = Console.readLine();
        checkWinValidator(input);
        InputData inputData = new InputData();
        lottolist = inputData.lottoMake(input);
        return lottolist;
    }
    public String inputBonusNumber(){
        String input = Console.readLine();
        checkBonusValidator(lottolist,input);
        return input;
    }


    private void checkNumberValidator(String input){
        MoneyValidation moneyValidation = new MoneyValidation();
        moneyValidation.validate(input);
    }

    private void checkWinValidator(String input){
        WinNumberValidation winNumberValidation = new WinNumberValidation();
        winNumberValidation.winValidate(input);
    }

    private void checkBonusValidator(List<String> winNumber, String input){
        BonusValidation bonusValidation = new BonusValidation();
        bonusValidation.bonusValidate(winNumber, input);
    }


}
