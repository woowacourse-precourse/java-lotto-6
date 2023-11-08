package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class Exception {

    private final static int LOTTO_NUMBERS_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int LOTTO_PRICE = 1000;
    private final static int ZERO = 0;
    private final static String ERROR = "[ERROR] ";


    public static void validateLottoNumbers(List<Integer> numbers) {
        notSixNumbers(numbers);
        for (Integer number : numbers) {
            numberNotInRange(number);
        }
        duplicateNumber(numbers);
    }

    public static void validateBonusNumber(List<Integer> wins, Integer bonus) {
        numberNotInRange(bonus);
        List<Integer> winsAndBonus = new ArrayList<>(wins);
        winsAndBonus.add(bonus);
        duplicateNumber(winsAndBonus);
    }

    public static void validateMoney(String input) {
        notParsableNumber(input);
        int money = Integer.parseInt(input);
        notPositiveNumber(money);
        notDividedWithThousand(money);
    }

    public static void validateSeparator(String input) {
        try {
            input.split(",");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 구분자가 ,가 아닙니다.");
        }
    }

    public static void notParsableNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "입력한 값을 정수로 변환할 수 없습니다.");
        }
    }

    private static void notSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR + "6개의 숫자를 가지고 있지 않습니다.");
        }
    }

    private static void numberNotInRange(int number) {
        if (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR + "1~45에 속하지 않는 숫자가 포함되어 있습니다.");
        }
    }

    private static void duplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR + "중복 숫자가 존재합니다.");
        }
    }

    private static void notPositiveNumber(int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(ERROR + "입력한 값이 0 이하의 숫자입니다.");
        }
    }

    private static void notDividedWithThousand(int number) {
        int remainder = number % LOTTO_PRICE;
        if (remainder > ZERO) {
            throw new IllegalArgumentException(ERROR + "1000으로 나눠 떨어지지 않습니다.");
        }
    }
}
