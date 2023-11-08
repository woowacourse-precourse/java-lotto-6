package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorMessage;
import lotto.validation.ErrorValidation;

public class PurchaseAmount implements UserInput {
    private int lottoQuantity;
    public static final int MIN_PURCHASE_LOTTO = 1000;
    public static final int MAX_PURCHASE_LOTTO = 100000;

    public void read() {
        lottoQuantity = singleTypeConversion(userInput()) / MIN_PURCHASE_LOTTO;
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

    public boolean addTicketByPurchaseAmount(int number) {
        return number < lottoQuantity;
    }

    public String purchasedAmountPrint() {
        return lottoQuantity + "개를 구매했습니다.";
    }

}
