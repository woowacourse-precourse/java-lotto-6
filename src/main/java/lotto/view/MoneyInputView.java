package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.NotNaturalMoneyException;
import lotto.exception.WrongMoneyInputFormatException;
import lotto.exception.WrongMoneyUnitException;
import lotto.validator.InputValidator;


public class MoneyInputView extends InputValidator {
    private static final String match = "^[1-9](\\d*)0{3}$";

    public static String input() {

        String money = Console.readLine();

        try {
            validate(money, match, new WrongMoneyInputFormatException());

        } catch(WrongMoneyInputFormatException e) {
            ErrorMessageView.print(e.getMessage());
            input();
        }

        return  money;
    }

}
