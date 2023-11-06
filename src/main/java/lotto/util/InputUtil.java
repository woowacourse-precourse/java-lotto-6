package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    private final static int MIN_AMOUNT = 0;
    private final static int AMOUNT_UNIT = 1000;
    public static int inputMoney() {
        try {
            String input = Console.readLine();
            int money = stringToInt(input);
            validateZeroOverMoney(money);
            validateOneThousandUnitsMoney(money);
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public static void inputWinningNumber() {
        String input = Console.readLine();
    }

    public static void inputBonusNumber() {
        String input = Console.readLine();
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void validateZeroOverMoney(int money) {
        if (money <= MIN_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 금액을 0원 이상 입력해주세요.");
        }
    }

    public static void validateOneThousandUnitsMoney(int money) {
        if (money % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해주세요.");
        }
    }
}
