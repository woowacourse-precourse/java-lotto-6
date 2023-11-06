package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
    public static String inputMoneyValue(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return money;
    }
}
