package lotto;
import camp.nextstep.edu.missionutils.Console;
public class BuyingLotto {

    static private int money;
    static private String input;
    static void gettingInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        input = Console.readLine();
        money = Integer.parseInt(input);
        validateInput();
    }

    static void validateInput() {
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            } else if (money < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingInput();
        }
    }


    static public int getMoney() {
        return money;
    }

    static public void setMoney(int money) {
        money = money;
    }
}
