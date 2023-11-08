package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.constant.IOMessage;

public class InputView {

    public String getInputMoney() {
        System.out.println(IOMessage.INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }
}
