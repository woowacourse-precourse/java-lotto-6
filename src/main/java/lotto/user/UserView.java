package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ViewMessage;

public class UserView {

    public String inputUserMoney(){
        System.out.println(ViewMessage.INPUT_MONEY_AMOUNT);
        return Console.readLine();
    }

}
