package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        return InputValidator.purchaseMoney(userMoney);
    }

}
