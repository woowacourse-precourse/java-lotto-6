package lotto.ui;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public int requestAmount() {
        while (true) {
            System.out.println("\n구입금액을 입력해 주세요.");
            try {
                int amount = validatedNumber(readLine());
                LottoGenerator.from(amount);

                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> requestNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                List<Integer> numbers = validatedNumbers(readLine());
                new Lotto(numbers);

                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int requestBonus(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int bonus = validatedNumber(readLine());
                WinningLotto.of(winningNumbers, bonus);

                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validatedNumbers(String input) {
        if (!input.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 구분자(,)만 입력 가능합니다.");
        }

        if (input.chars().noneMatch(ch -> ch == ',')) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 구분자(,)로 구분해 입력하세요.");
        }

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private static int validatedNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        return Integer.parseInt(input);
    }
}