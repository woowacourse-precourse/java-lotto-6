package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInput {
    public static String inputAmount() {
        String amount = Console.readLine();
        validateAmount(amount);
        return amount;
    }

    public static List<Integer> inputNumber() {
        String numbers = Console.readLine();
        List<Integer> number = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map((Integer::parseInt))
                .peek(UserInput::validateNumber)
                .collect(Collectors.toList());
        validateUniqueNumber(number);
        return number;
    }

    public static int inputBonus() {
        String bonus = Console.readLine();
        validateNumber(Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }

    private static void validateAmount(String amount) {
        if (amount == null || Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해 주세요.");
        }
    }

    private static void validateNumber(Integer number) {
        if (number == null || number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateUniqueNumber(List<Integer> number) {
        Set<Integer> uniqueNames = new HashSet<>(number);
        if (uniqueNames.size() < number.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
