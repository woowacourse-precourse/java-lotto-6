package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
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

    public static List<String> inputNumber() {
        String numbers = Console.readLine();
        List<String> number = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .peek(UserInput::validateNumber)
                .collect(Collectors.toList());
        validateUniqueNumber(number);
        return number;
    }

    private static void validateAmount(String amount) {
        if (amount == null || Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해 주세요.");
        }
    }

    private static void validateNumber(String number) {
        if (number == null || Integer.parseInt(number) > 45 || Integer.parseInt(number) < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateUniqueNumber(List<String> number) {       // 자동차 이름 중복 제거
        Set<String> uniqueNames = new HashSet<>(number);
        if (uniqueNames.size() < number.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
