package lotto.view;

import lotto.InputMessage;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputMoney(){
        System.out.println(InputMessage.INPUT_MONEY);
        String money=Console.readLine();
        return money;
    }

}
