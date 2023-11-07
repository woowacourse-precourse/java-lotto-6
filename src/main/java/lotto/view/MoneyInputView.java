package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.NotNaturalMoneyException;
import lotto.exception.WrongMoneyInputFormatException;
import lotto.exception.WrongMoneyUnitException;


public class MoneyInputView {
    private static final String match = "^[1-9](\\d*)0{3}$";

    public static String input() {

        String money = Console.readLine();

        try {
            validateMoney(money);

        } catch(WrongMoneyInputFormatException e) {
            ErrorMessageView.print(e.getMessage());
            input();
        }

        return  money;
    }

    private static void validateMoney(String moneyInput) {
        Pattern matcher = Pattern.compile(match);
        Matcher matcher1 = matcher.matcher(moneyInput);
        if (!matcher1.find()) {
            throw new WrongMoneyInputFormatException();
        }


    }
}
