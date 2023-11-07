package lotto.view;

import lotto.Message;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputMoney(){
        System.out.println(Message.INPUT_MONEY);
        String money=Console.readLine();
        return money;
    }

}
