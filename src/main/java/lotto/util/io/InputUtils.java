package lotto.util.io;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.StringUtils;

public class InputUtils {
    public static int getPurchaseAmount() {
        String money = Console.readLine();
        validateInputMoney(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        if (isNull(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        List<String> numbers = StringUtils.splitByCommaAndTrim(input);
        validateInputWinningNumbers(numbers);
        return numbers.stream().map(Integer::parseInt).collect(toList());
    }

    private static void validateInputMoney(String money) {
        if (isNull(money)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        if (!isNumeric(money)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if (isNumeric(money) && Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000단위의 값을 입력해야 합니다.");
        }
    }

    private static void validateInputWinningNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호 모두 숫자를 입력해야 합니다.");
            }
            if (!isNumberInRange(Integer.parseInt(number))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    private static boolean isNumeric(String number) {
        return number.matches("\\d+");
    }

    private static boolean isNull(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isNumberInRange(int number) {
        return number >= 1 && number <= 45;
    }

    private static boolean hasDuplicates(List<String> input) {
        Set<String> uniqueElements = new HashSet<>(input);
        return input.size() != uniqueElements.size();
    }

}
