package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.validation.ErrorMessage;
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
            System.out.println(ErrorMessage.ERROR_PURCHASE_MIN_MAX.getMessage());
            readMoney = userInput();
        }
        return readMoney;
    }

    public int singleTypeConversion(String money) {
        return Integer.parseInt(money) / 1000;
    }




}
