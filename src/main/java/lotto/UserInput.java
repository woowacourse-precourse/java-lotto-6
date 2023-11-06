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
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            String[] numberStrings = input.split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String numberString : numberStrings) {
                numberString = numberString.trim();
                int number = Integer.parseInt(numberString);
                numbers.add(number);
            }
            return numbers;
        }
    }
}
