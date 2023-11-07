package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    public static Lotto lotto;
    public static int bonus;

    private static final String WINNING_INPUT_TEXT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_TEXT = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_NOT_SIX_TEXT = "[ERROR] 여섯 개를 입력해주세요.";
    private static final String ERROR_NOT_INTEGER_TEXT = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_NOT_IN_RANGE_TEXT = "[ERROR] 1 ~ 45 범위 내의 숫자를 입력해주세요.";
    private static final String ERROR_DUPLICATE_NUM_TEXT = "[ERROR] 서로 다른 숫자를 입력해주세요.";

    public static void setWinningLotto() {
            setLotto();
            setBonus();
    }

    private static void setLotto() {
        while (true) {
            try {
                System.out.println(WINNING_INPUT_TEXT);
                String lottoInput = Console.readLine();
                List<String> splittedInput = splitLotto(lottoInput);
                List<Integer> parsed = toListInt(splittedInput);
                lotto = new Lotto(parsed);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void setBonus() {
        while (true) {
            try {
                System.out.println(BONUS_INPUT_TEXT);
                String bonusInput = Console.readLine();
                bonus = validateStringIsNum(lotto.getNumbers(), bonusInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> splitLotto(String input) {
        List<String> splittedInput = List.of(input.split(","));
        validateInputSize(splittedInput);

        return splittedInput;
    }

    private static List<Integer> toListInt(List<String> nums) {
        List<Integer> parsed = new ArrayList<>();
        for (String num : nums) {
            int number = validateStringIsNum(parsed, num);
            parsed.add(number);
        }

        return parsed;
    }

    private static int validateStringIsNum(List<Integer> existing, String input) {
        try {
            int number = Integer.parseInt(input);
            validateNumRange(number);
            validateNonDuplicate(existing, number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_TEXT);
        }
    }

    private static void validateInputSize(List<String> toCheck) {
        if (toCheck.size() != 6) {
            throw new IllegalArgumentException(ERROR_NOT_SIX_TEXT);
        }
    }

    private static void validateNumRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_NOT_IN_RANGE_TEXT);
        }
    }

    private static void validateNonDuplicate(List<Integer> existing, int current) {
        if (existing.contains(current)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUM_TEXT);
        }
    }
}
