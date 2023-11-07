package lotto;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    static final String prefix = "[ERROR] ";
    private static Validator validator = new Validator();

    private Validator() {

    }

    public static Validator getInstance() {
        return validator;
    }

    public static int validatePrice(String input) {
        int price = 0;
        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(prefix + "숫자가 아닙니다.");
        }
        if (price % 1000 != 0 || price <= 0) {
            throw new IllegalArgumentException(prefix + "잘못된 입력입니다.");
        }
        return price;
    }

}
