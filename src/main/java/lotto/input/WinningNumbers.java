package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbers extends NumberInput {
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 6개의 서로 다른 숫자를 입력하세요.";
    public static Set<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return inputNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Set<Integer> inputNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        String input = Console.readLine();
        String[] inputNumbers = input.split(",");
        validateInput(inputNumbers, winningNumbers);
        System.out.println();
        return winningNumbers;
    }

    protected static void validateInput(String[] inputNumbers, Set<Integer> winningNumbers) {
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        storeNumbers(inputNumbers, winningNumbers);
    }

    private static void storeNumbers(String[] inputNumbers, Set<Integer> winningNumbers) {
        for (String number : inputNumbers) {
            int winningNum = validateNumberFormat(number.trim());
            validateNumberRange(winningNum);
            validateDuplicate(winningNum, winningNumbers);
        }
    }
}