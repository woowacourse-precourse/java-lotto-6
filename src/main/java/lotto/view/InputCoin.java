package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constant;
import lotto.exception.NotNumberException;
import lotto.exception.ThousandCheckException;

public class InputCoin {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";

    public Integer insertCoin() {
        printNotice();
        String insertCoin = Console.readLine();
        validate(insertCoin);
        return convertNumber(insertCoin);
    }

    public void printNotice() {
        System.out.println(START_MESSAGE);
    }

    public void validate(String insertCoin) {
        validateMoney(insertCoin);
        validateMoneyIsDivided(insertCoin);
    }

    public int convertNumber(String insertCoin) {
        return Integer.parseInt(insertCoin);
    }

    public void validateMoney(String insertCoin) {
        if(!isNumberString(insertCoin)) {
            throw new NotNumberException();
        }
    }

    public void validateMoneyIsDivided(String insertCoin) {
        int money = Integer.parseInt(insertCoin);
        if(money % Constant.MONEY_UNIT != 0) {
            throw new ThousandCheckException();
        }
    }

    public boolean isNumberString(String insertCoin) {
        if(insertCoin.isBlank()) {
            return false;
        }
        for (int i = 0; i < insertCoin.length(); i++) {
            char uncheckedCharacter = insertCoin.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }
}
