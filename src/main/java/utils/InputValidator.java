package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
    public static int validateAndParsePurchaseAmount() {
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        int amount = Integer.parseInt(input.trim());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자여야 합니다.");
        }
        return amount;
    }

    public static List<Integer> validateAndParseWinningNumbers() {
        String input = Console.readLine();
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (numbers.size() != 6 || numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
        }
        return numbers;
    }

    public static int validateAndParseBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input.trim());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 잘못되었습니다.");
        }
        return bonusNumber;
    }
}
