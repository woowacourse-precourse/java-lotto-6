package lotto.util.io;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.StringUtils;

public class InputUtils {

    private static final int COUNT_OF_WINNING_NUMBER = 6;
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int PRICE_PER_TICKET = 1000;

    public static int getPurchaseAmount() {
        String money = Console.readLine();
        validateInputMoney(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        if (isEmpty(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        List<String> numbers = StringUtils.splitByCommaAndTrim(input);
        validateInputWinningNumbers(numbers);
        return numbers.stream().map(Integer::parseInt).collect(toList());
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String number = Console.readLine();
        validateInputBonusNumber(number, winningNumbers);
        return Integer.parseInt(number);
    }

    public static void validateInputMoney(String money) {
        if (isEmpty(money)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        if (!isNumeric(money)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if (isNumeric(money) && Integer.parseInt(money) % PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000단위의 값을 입력해야 합니다.");
        }
    }

    public static void validateInputWinningNumbers(List<String> numbers) {
        for (String number : numbers) {
            validateInputWinningNumber(number);
        }
        if (numbers.size() != COUNT_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개이어야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    private static void validateInputWinningNumber(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 모두 숫자를 입력해야 합니다.");
        }
        if (!isNumberInRange(Integer.parseInt(number))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateInputBonusNumber(String number, List<Integer> winningNumbers) {
        if (isEmpty(number)) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
        if (!isNumberInRange(Integer.parseInt(number))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");
        }
    }

    private static boolean isNumeric(String number) {
        return number.matches("\\d+");
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isNumberInRange(int number) {
        return number >= LOTTO_MINIMUM_NUMBER && number <= LOTTO_MAXIMUM_NUMBER;
    }

    private static boolean hasDuplicates(List<String> input) {
        Set<String> uniqueElements = new HashSet<>(input);
        return input.size() != uniqueElements.size();
    }

}
