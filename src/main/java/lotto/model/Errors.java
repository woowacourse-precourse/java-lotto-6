package lotto.model;

import lotto.view.OutputView;

public class Errors {
    public static int isInteger (String str) throws IllegalArgumentException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            OutputView.printIsInteger();
            throw new IllegalArgumentException();
        }
    }

    public static void isMinMoney (int money) throws IllegalArgumentException {
        if(money < 1000) {
            OutputView.printIsMinMoney();
            throw new IllegalArgumentException();
        }
    }

    public static void isWrongMoney (int money) throws IllegalArgumentException {
        if(money % 1000 != 0) {
            OutputView.printIsWrongMoney();
            throw new IllegalArgumentException();
        }
    }

    public static void isWrongRange (int num) throws IllegalArgumentException {
        if(num < 1 || num > 45) {
            OutputView.printIsWrongRange();
            throw new IllegalArgumentException();
        }
    }


}
