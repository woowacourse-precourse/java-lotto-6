package lotto.view;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.message.Error.VALID_INPUT;
import static lotto.util.message.Input.*;

public class InputLotto {
    static final int MOD_NUM = 1000;
    static final int LOTTO_NUM_LENGTH = 6;

    public static int purchaseMoney() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_MONEY);
                return readMoney();
            } catch (NumberFormatException e) {
                System.out.println(VALID_INPUT);
            } catch (IllegalArgumentException e) {
                System.out.println(VALID_INPUT);
            }
        }
    }

    public static List<Integer> answerNumber() {
        while (true) {
            try {
                System.out.println(INPUT_ANSWER_NUMBER);
                return readAnswer();
            } catch (NumberFormatException e) {
                System.out.println(VALID_INPUT);
            } catch (IllegalArgumentException e) {
                System.out.println(VALID_INPUT);
            }
        }
    }

    public static int bonusNumber() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                return readBonus();
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

    private static List<Integer> readAnswer() {
        String[] input = readLine().split(",");
        if (input.length != LOTTO_NUM_LENGTH) {
            throw new IllegalArgumentException(VALID_INPUT);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUM_LENGTH; i++) {
            Integer num = Integer.parseInt(input[i]);
            result.add(num);
            exceptNumberRange(num); // 범위 체크
        }
        return result;
    }

    private static int readBonus() {
        Integer input = Integer.parseInt(readLine());
        exceptNumberRange(input); // 범위 체크
        return input;
    }

    private static void exceptNumberRange(int num) {
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException(VALID_INPUT);
        }
    }
}
