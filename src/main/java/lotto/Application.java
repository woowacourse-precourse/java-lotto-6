package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

class money_for_lotto{
    public static String inputNumber;

    public static int realMoney(String inputNumber){
        return Integer.parseInt(inputNumber);
    }

}

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        money_for_lotto money = new money_for_lotto();
        money.realMoney(inputMoney);
    }
}
