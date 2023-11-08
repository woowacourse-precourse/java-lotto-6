package lotto.view;


import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.message.Error.VALID_INPUT;

public class InputLotto {
    static final int MOD_NUM = 1000;
    static final int LOTTO_NUM_LENGTH = 6;

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

    public static int[] answerNumber() {
        while (true) {
            try {
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

    private static int[] readAnswer() {
        String[] input = readLine().split(",");
        if (input.length != LOTTO_NUM_LENGTH) {
            throw new IllegalArgumentException(VALID_INPUT);
        }
        int[] result = new int[LOTTO_NUM_LENGTH];
        for (int i = 0; i < LOTTO_NUM_LENGTH; i++) {
            result[i] = Integer.parseInt(input[i]);
            exceptNumberRange(result[i]); // 범위 체크
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
