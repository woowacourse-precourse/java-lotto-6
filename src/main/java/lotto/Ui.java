package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Ui {

    public void print(String notification) {

        System.out.println(notification);
    }

    public String input() {

        return Console.readLine();
    }

    public Integer checkPurchaseAmount(String inputAmount) {

        try {
            int intInput = checkInteger(inputAmount);
            checkNegative(intInput);
            return check1000(intInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int checkInteger(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            print(ExceptionMessage.notInteger.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void checkNegative(int input) {

        if (input < 0) {
            print(ExceptionMessage.negativeValue.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public Integer check1000(int input) {

        if (input % 1000 != 0) {
            print(ExceptionMessage.not1000Value.getMessage());
            throw new IllegalArgumentException();
        }

        return input/1000;
    }
}
