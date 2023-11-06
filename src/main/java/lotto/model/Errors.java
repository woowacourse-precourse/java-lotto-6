package lotto.model;

import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

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

    public static void isDuplicate (List<Integer> List, int num) throws IllegalArgumentException {
        for(int i = 0; i < List.size(); i++) {
            if(List.get(i) == num) {
                OutputView.printIsDuplicate();
                throw new IllegalArgumentException();
            }
        }
    }
}
