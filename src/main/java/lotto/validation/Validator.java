package lotto.validation;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {
    private static Integer MINIMUM = 1;
    private static Integer MAXIMUM = 45;

    public static void moneyValidate(String input) {
        Integer money = numberValidate(input);
        noMoneyValidate(money);
    }

    public static void winningValidate(String[] input) {
        blankValidate(input);
        winningNumDuplicatedValidate(input);
        winningNumValidate(input);
        numberRangeValidate(input);
    }

    public static void bonusValidate(String input, ArrayList<Integer> winningNum) {
        numberValidate(input);
        bonusRangeValidate(input);
        bonusNumDuplicatedValidate(input, winningNum);
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

    private static void blankValidate(String[] winningNum) {
        if (winningNum.length!=6){
            OutputView.errorMessage(ErrorMessage.BLANK_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private static void winningNumDuplicatedValidate(String[] winningNum) {
        long numSize=Arrays.stream(winningNum)
                .distinct()
                .count();

        if(numSize!=6){
            OutputView.errorMessage(ErrorMessage.DUPLICATED_ERROR.getMessage());

            throw new IllegalArgumentException();
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

            if(number<MINIMUM || number>MAXIMUM){
                OutputView.errorMessage(ErrorMessage.RANGE_ERROR.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private static void bonusRangeValidate(String bonusNum) {
        Integer number = Integer.parseInt(bonusNum);

        if (number < MINIMUM || number > MAXIMUM) {
            OutputView.errorMessage(ErrorMessage.BONUS_RANGE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void bonusNumDuplicatedValidate(String bonusNum, ArrayList<Integer> winningNum) {
        winningNum.add(Integer.parseInt(bonusNum));

        long count = winningNum.stream()
                .distinct()
                .count();

        if (count != 7) {
            OutputView.errorMessage(ErrorMessage.BONUS_DUPLICATED_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
