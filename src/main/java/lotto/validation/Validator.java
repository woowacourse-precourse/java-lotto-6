package lotto.validation;

import lotto.view.OutputView;

public class Validator {
    private static Integer PRICE=1000;
    private static Integer MINIMUM = 1;
    private static Integer MAXIMUM = 45;

    public static void moneyValidate(String input) {
        Integer money = numberValidate(input);
        noMoneyValidate(money);
        divideValidate(money);
    }

    public static void winningValidate(String[] input) {
        blankValidate(input);
        winningNumValidate(input);
        numberRangeValidate(input);
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
        if(money<PRICE){
            OutputView.errorMessage(ErrorMessage.NO_MONEY.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private static void divideValidate(Integer money) {
        if(money % PRICE !=0){
            OutputView.errorMessage(ErrorMessage.DIVIDE_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private static void blankValidate(String[] winningNum) {
        for (String num : winningNum) {
            if(num.trim().isEmpty()){
                OutputView.errorMessage(ErrorMessage.BLANK_ERROR.getMessage());

                throw new IllegalArgumentException();
            }
        }
    }

    private static void winningNumValidate(String[] winningNum) {
        for (String num : winningNum) {
            numberValidate(num);
        }
    }

    private static void numberRangeValidate(String[] winningNum) {
        for (String num : winningNum) {
            Integer number = Integer.parseInt(num);

            if(number>MAXIMUM || number<MINIMUM){
                OutputView.errorMessage(ErrorMessage.RANGE_ERROR.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }
}
