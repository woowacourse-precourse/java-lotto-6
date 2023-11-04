package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

public class InputView {

    private static final String PURCHASE_AMOUNT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    InputValidation inputValidation = new InputValidation();

    public String purchaseAmountMoney(){
        try{
            System.out.println(PURCHASE_AMOUNT_MONEY_MESSAGE);
            String money = Console.readLine();
            inputValidation.validationMoney(money);
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return purchaseAmountMoney();
        }
    }
}
