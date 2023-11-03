package lotto.VIew;

import static lotto.Message.InputVIewMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    @Override
    public String inputMoney() {
        System.out.println(INPUTPERCHASEPROMPT.getMessage());
        return Console.readLine();
    }

    @Override
    public String inputWinningNumber() {
        System.out.println(INPUTWINNINGNUMBERPROMPT.getMessage());
        return Console.readLine();
    }

    @Override
    public String inputBonusNumber() {
        System.out.println(INPUTBONUSNUMBERPROMPT.getMessage());
        String bonusNumber = Console.readLine();
        Console.close();
        return bonusNumber;
    }
}
