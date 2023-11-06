package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class PurchaseAmount implements UserInput {
    public static int lottoQuantity;

    public void read() {
        lottoQuantity = singleTypeConversion(userInput());
    }

    public String userInput() {
        String readMoney = Console.readLine();
        try {
            isNumberVerify(readMoney);
            isInRangeVerify(readMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구매 가격은 최소 1,000원부터 최대 100,000원까지 입력 가능합니다.");
            readMoney = userInput();
        }
        return readMoney;
    }

    public int singleTypeConversion(String money) {

        return Integer.parseInt(money) / 1000;
    }

    public void isNumberVerify(String userInput) {
        if (!Pattern.matches("^\\d+$", userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public void isInRangeVerify(String userInput) {
        int money = Integer.parseInt(userInput);
        if (!((money >= 1000) && (money <= 100000))) {
            throw new IllegalArgumentException();
        }
    }

}
