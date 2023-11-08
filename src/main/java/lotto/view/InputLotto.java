package lotto.view;


import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.message.Error.VALID_INPUT;

public class InputLotto {
    static final int MOD_NUM = 1000;

    public static int purchaseMoney() {
        while (true) {
            try {
                return readMoney();
            } catch (NumberFormatException e) {
                System.out.println(VALID_INPUT);
            } catch (IllegalArgumentException e) {
                System.out.println(VALID_INPUT);
            }
        }
    }

    private static int readMoney() {
        Integer input = Integer.parseInt(readLine());
        if (input % MOD_NUM != 0) {
            throw new IllegalArgumentException(VALID_INPUT);
        }
        return input / MOD_NUM;
    }
}
