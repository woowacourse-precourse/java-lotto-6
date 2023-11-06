package lotto.view;

import lotto.exception.BlankException;
import lotto.exception.NotNumberException;
import lotto.exception.ThousandCheckException;
import lotto.exception.ZeroMoreThanException;

import java.util.regex.Pattern;

public class InputCoin {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private final InputThings inputThings = new InputThings();

    public Integer insertCoin() {
        printNotice();
        String insertCoin = inputThings.inputThings().trim();
        validate(insertCoin);
        return Integer.parseInt(insertCoin);
    }

    public void printNotice() {
        System.out.println(START_MESSAGE);
    }

    public void validate(String insertCoin) {
        blankCoin(insertCoin);
        numberValidateCoin(insertCoin);
    }

    private void blankCoin(String insertCoin) {
        if (insertCoin == null) {
            throw new BlankException();
        }
    }

    private void numberValidateCoin(String insertCoin) {
        String num = "^[0-9]*$";
        if (!Pattern.matches(insertCoin, num)) {
            throw new NotNumberException();
        }
    }
}
