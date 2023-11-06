package lotto;
import camp.nextstep.edu.missionutils.Console;
public class BuyingLotto {

    static private int money;
    static private String input;
    static void gettingInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        input = Console.readLine();
        money = Integer.parseInt(input);
    }



    static public int getMoney() {
        return money;
    }

    static public void setMoney(int money) {
        money = money;
    }
}
