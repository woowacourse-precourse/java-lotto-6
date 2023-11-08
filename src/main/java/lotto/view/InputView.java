package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.repository.LottoRepository;

public class InputView {
    private static final String INPUT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static int inputBudget() {
        while (true) {
            try {
                System.out.println("구매금액을 입력해 주세요.");
                String input = Console.readLine();
                validateBudgetInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            }
        }
    }

    private static void validateBudgetInput(String input) {
        if (!isPositiveNonZeroInteger(input) || !isDivisible(input, LottoRepository.LOTTO_PRICE)) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해주세요.");
                String input = Console.readLine();
                validateWinningNumbersInput(input);
                return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            }
        }
    }

    private static void validateWinningNumbersInput(String input) {
        if (!isSixNumberAndComma(input) || !isInRangeAndNoDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateBonusNumber(winningNumbers, input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            }
        }
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, String input) {
        if (!isPositiveNonZeroInteger(input)) {
            throw new IllegalArgumentException();
        }
        int number = Integer.parseInt(input);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isPositiveNonZeroInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDivisible(String input, int divisor) {
        int dividend = Integer.parseInt(input);
        return dividend % divisor == 0;
    }

    private static boolean isSixNumberAndComma(String input) {
        return input.matches("^(\\d+,){5}\\d+$");
    }

    private static boolean isInRangeAndNoDuplicate(String input) {
        List<Integer> temp = new ArrayList<>();
        String[] arr = input.split(",");
        for (String s : arr) {
            int i = Integer.parseInt(s);
            if (temp.contains(i) || i < 1 || i > 45) {
                return false;
            }
            temp.add(i);
        }
        return true;
    }
}
