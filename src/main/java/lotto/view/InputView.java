package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String buyMoney(){
        System.out.println("로또 구입 금액을 입력해주세요.");
        String buyMoney = Console.readLine();
        return buyMoney;
    }
}
