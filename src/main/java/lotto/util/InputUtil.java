package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static int inputMoney() {
        while (true) {
            try {
                String input = Console.readLine();
                int money = stringToInt(input);
                validateZeroOverMoney(money);
                validateOnethousandUnitsMoney(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
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
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 0원 이상 입력해주세요.");
        }
    }

    public static void validateOnethousandUnitsMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해주세요.");
        }
    }
}
