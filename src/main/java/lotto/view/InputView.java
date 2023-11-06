package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Constants;
import lotto.utils.Split;
import lotto.utils.ValidateCheck;

import java.util.List;

public class InputView {
    public static int intputAmount(String input){
        ValidateCheck.pureIntegerCheck(input);
        int amount = Integer.parseInt(input);
        ValidateCheck.inputAmountValidate(amount)
        return amount/Constants.LOTTO_PRICE.getNumber();
    }

    public static List<Integer> choiceNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<Integer> inputWinNumbers(String input){
        List<Integer> winNumbers = Split.splitStringToInteger(input);
        ValidateCheck.numberCountValidate(winNumbers);
        ValidateCheck.numberDupulicationValidate(winNumbers);
        ValidateCheck.numbersRangeValidate(winNumbers);
        return winNumbers;
    }

}
