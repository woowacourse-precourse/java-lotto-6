package lotto.view;

import lotto.exception.BlankException;
import lotto.exception.ThousandCheckException;
import lotto.exception.ZeroMoreThanException;

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
        zeroMoreThaCoin(Integer.parseInt(insertCoin));
        thousandCheck(Integer.parseInt(insertCoin));
    }

    public void blankCoin(String insertCoin) {
        if (insertCoin == null) {
            throw new BlankException();
        }
    }

    public void zeroMoreThaCoin(int coin) {
        if (coin <= 0) {
            throw new ZeroMoreThanException();
        }
    }

    public void thousandCheck(int coin) {
        if (coin % 1000 != 0) {
            throw new ThousandCheckException();
        }
    }
}
