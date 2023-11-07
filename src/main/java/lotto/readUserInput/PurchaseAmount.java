package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorMessage;
import lotto.validation.ErrorValidation;

public class PurchaseAmount implements UserInput {
    public static int lottoQuantity;

    public void read() {
        lottoQuantity = singleTypeConversion(userInput()) / 1000;
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

    public int singleTypeConversion(String readMoney) {
        int money = Integer.parseInt(readMoney);
        try {
            ErrorValidation.isDividedOneThousand(money);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ERROR_PURCHASE_DIVIDED_ONE_THOUSAND.getMessage());
            money = singleTypeConversion(userInput());
        }
        return money;
    }


}
