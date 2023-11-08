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

    private static boolean isDivisible(String input, int divisor) {
        int dividend = Integer.parseInt(input);
        return dividend % divisor == 0;
    }

    private static boolean isSixNumberAndComma(String input) {
        return input.matches("^(\\d+,){5}\\d+$");
    }
}
