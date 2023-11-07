package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.validation.ErrorValidation;

public class PurchaseAmount implements UserInput {
    public static int lottoQuantity;

    public void read() {
        lottoQuantity = singleTypeConversion(userInput());
    }

    public String userInput() {
        String readMoney = Console.readLine();
        try {
            ErrorValidation.isNumberVerify(readMoney);
            ErrorValidation.isMoneyInRange(readMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구매 가격은 최소 1,000원부터 최대 100,000원까지 입력 가능합니다.");
            readMoney = userInput();
        }
        return readMoney;
    }

    public int singleTypeConversion(String money) {
        return Integer.parseInt(money) / 1000;
    }




}
