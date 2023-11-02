package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.ErrorMessage.NOT_POSITIVE_INTEGER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.LottoException;

public class InputView {

    private static final Pattern ZERO_OR_PASITIVE_NUMBER = Pattern.compile("^[0-9]+$");
    private static final String ENTER_MONEY = "구입금액을 입력해 주세요.";

    public int enterMoney() {
        System.out.println(ENTER_MONEY);

        return convertToInt(readLine());
    }

    private int convertToInt(String money) {
        validateNumber(money);

        return Integer.parseInt(money);
    }


    private void validateNumber(final String money) {
        if (isNotNumber(money)) {
            throw LottoException.of(NOT_POSITIVE_INTEGER);
        }

    }

    private boolean isNotNumber(final String money) {
        Matcher matcher = ZERO_OR_PASITIVE_NUMBER.matcher(money);

        return !matcher.matches();
    }
}
