package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

public class BonusNumber extends NumberInput {
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복되지 않는 숫자 1개를 입력하세요.";
    public static int bonusInput(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return validateBonusInput(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validateBonusInput(Set<Integer> winningNumbers) {
        String input = Console.readLine();
        validateInputLength(input, LENGTH_ERROR_MESSAGE);
        int bonus = validateNumberFormat(input);
        validateNumberRange(bonus);
        validateDuplicate(bonus, winningNumbers);
        return bonus;
    }

    private static void validateInputLength(String input, String errorMessage) {
        String[] numbers = input.split(",");
        if (numbers.length != 1) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}