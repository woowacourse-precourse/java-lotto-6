package lotto.util.io;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static int getPurchaseAmount() {
        String money = Console.readLine();
        validateInputMoney(money);
        return Integer.parseInt(money);
    }

    private static void validateInputMoney(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if (isNumeric(money) && Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000단위의 값을 입력해야 합니다.");
        }
    }

    private static boolean isNumeric(String number) {
        return number.matches("\\d+");
    }
}
