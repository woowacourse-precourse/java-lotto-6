package validate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Validator {

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 최대 입니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalStateException("[ERROR] 로또 번호의 숫자는 중복될 수 없습니다..");
        }
    }
    public static int[] validateWinningNumber(int[] numbers) {
        Set<Integer> winningNumbers = new HashSet<>();
        for (int number : numbers) {
            boolean isAdded = winningNumbers.add(number);
            if (!isAdded) { //set에 추가 되지 않았다면 중복이 있는것.
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 서로 중복될 수 없습니다.");
            }
        }
        return numbers;
    }
    public static void validateSize(int[] numbers) {
        if (numbers.length!= 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자는 6자리 입니다.");
        }
    }
    public static void validateBonusNumber(int userInputBonusNumber) {
        if (userInputBonusNumber < 1 || userInputBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자만 입력 가능합니다.");
        }
    }

    public static void isInvalidPriceUnit(int userInputPrice) {
        if (userInputPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
    public static void validateNumericInput(String input) {
        // 정규 표현식을 사용하여 입력값이 숫자만 포함하는지 검사
        if (!input.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 구입 금액은 문자를 포함할 수 없습니다.");
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
}
