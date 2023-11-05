package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Log;

public class Input {
    private static final int LOTTO_PRICE = 1000;
    private static final int MINIMUM_PRICE = 0;


    public int buyMoney() {
        try {
            int money = stringToInt(Console.readLine());
            checkPriceByThousandWonUnitAndMinimum(money);
            return money;
        } catch (IllegalArgumentException errorMessage) {
            Log.println(errorMessage.getMessage());
        }
        return buyMoney();
    }

    private void checkPriceByThousandWonUnitAndMinimum(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 가격은 천원 단위입니다.");
        }
        if (MINIMUM_PRICE >= money) {
            throw new IllegalArgumentException("[ERROR] 1장 이상 구매해야 합니다.");
        }
    }

    private int stringToInt(String readLine) {
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException errorMessage) {
            throw new NumberFormatException("[ERROR] 숫자로 입력해야 합니다.");
        }
    }
}
