package lotto.view;

import lotto.InputMessage;

import camp.nextstep.edu.missionutils.Console;
import lotto.OutputMessage;

public class InputView {

    public String inputMoney(){
        System.out.println(InputMessage.INPUT_MONEY);
        String money=Console.readLine();
        return money;
    }

    public String inputWinNumbers(){
        System.out.println(InputMessage.INPUT_WIN_NUMBERS);
        String winNumbers=Console.readLine();
        return winNumbers;
    }

    public String inputBonusNumber(){
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
