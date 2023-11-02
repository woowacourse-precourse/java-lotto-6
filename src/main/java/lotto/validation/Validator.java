package lotto.validation;

import lotto.view.OutputView;

import java.util.ArrayList;

public class Validator {

    public static void moneyValidate(String input) {
        Integer money = numberValidate(input);
        noMoneyValidate(money);
    }

    private static Integer numberValidate(String input){
        Integer money;

        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.errorMessage(ErrorMessage.NUM_ERROR.getMessage());

            throw new IllegalArgumentException();
        }

        return money;
    }

    private static void noMoneyValidate(Integer money) {
        if(money<1000){
            OutputView.errorMessage(ErrorMessage.NO_MONEY.getMessage());

            throw new IllegalArgumentException();
        }
    }



}
