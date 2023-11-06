package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                List<Integer> numbers = new ArrayList<>();
                for (String numberString : numberStrings) {
                    numberString = numberString.trim();
                    int number = Integer.parseInt(numberString);
                    numbers.add(number);
                }
                validateNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
