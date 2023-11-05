package lotto.input;

import static lotto.exception.ExceptionMessage.WRONG_LOTTO_NUMBER;
import static lotto.lotto.LottoSimulator.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

final class LottoMoneyInputManager {
    private LottoMoneyInputManager() {
    }

    static int fromConsole() {
        String input = Console.readLine();
        return fromString(input);
    }

    static int fromString(String input) {
        return convertInputToMoney(input);
    }

    private static int convertInputToMoney(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER);
        }
        validateLottoMoneySize(money);
        validateNoRemain(money);
        return money;
    }

    private static void validateLottoMoneySize(int money) {
        if (money > 2147483000 || money < 0) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER);
        }
    }

    private static void validateNoRemain(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_IS_NOT_MULTIPLE_OF_LOTTO_PRICE);
        }
    }
}
