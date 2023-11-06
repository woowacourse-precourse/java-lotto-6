package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.Constants;
import lotto.enums.Messages;
import lotto.utils.ValidateCheck;

import java.util.List;

public class InputView {
    public static int intputAmount(String input){
        if(!ValidateCheck.pureIntegerCheck(input)){
            throw new IllegalArgumentException(Messages.PURE_INTEGER_ERROR_MESSAGE.getMessage());
        }
        int amount = Integer.parseInt(input);
        if(!ValidateCheck.inputAmountValidate(amount)){
            throw new IllegalArgumentException(Messages.PRICE_DEVIDE_ERROR_MESSAGE.getMessage());
        }
        return amount/Constants.LOTTO_PRICE.getNumber();
    }


    public static List<Integer> choiceNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
