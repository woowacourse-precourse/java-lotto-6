package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    // 로또 구입 금액 입력 검증
    public static void validateAmount(String amount) {
        checkBlankOrNULL(amount);
        checkContainSpace(amount);
        checkNAN(amount);
        checkDividedBy(1000, Integer.parseInt(amount));
    }

    // 당첨 번호 입력 검증
    public static void validateWinNumbers(String winSequence) {
        checkBlankOrNULL(winSequence);
        checkInvalidComma(winSequence);
        checkValidSize(winSequence);
        checkContainSpace(winSequence);
        List<String> numbers = Arrays.asList(winSequence.split(","));
        List<Integer> intNumbers = new ArrayList<>();
        for (String number : numbers) {
            checkNAN(number);
            checkNumberIn(1, 45, Integer.parseInt(number));
            intNumbers.add(Integer.parseInt(number));
        }
        checkDuplicated(intNumbers);
    }

    // 보너스 번호 입력 검증
    public static void validateBonusNumber(String number, List<Integer> numbers) {
        checkBlankOrNULL(number);
        checkContainSpace(number);
        checkNAN(number);
        checkNumberIn(1, 45, Integer.valueOf(number));
        checkNumberInList(Integer.valueOf(number), numbers);
    }

    // 공백이거나 NULL인지 검증
    public static void checkBlankOrNULL(String input) {
        if (input.equals("") || input == null)
            throw new IllegalArgumentException("[ERROR] 공백이거나 NULL인 입력입니다.");
    }

    // 공백문자를 포함하는지 검증
    public static void checkContainSpace(String input) {
        if (input.contains(" "))
            throw new IllegalArgumentException("[ERROR] 공백문자를 포함하는 입력입니다.");
    }

    // 양의 정수 입력이 맞는지 검증
    public static void checkNAN(String input) {
        try {
            Integer number = Integer.parseInt(input);
            if (number < 0)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 양수입니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 입력이어야 합니다.");
        }
    }

    // 1000원으로 나누어 떨어지는지 검증
    public static void checkDividedBy(int divisor, Integer amount) {
        if (amount % divisor != 0)
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지지 않는 금액입니다.");
    }

    // ,,가 포함되어 있거나 ,로 시작하거나 끝나는지 검증
    public static void checkInvalidComma(String input) {
        if (input.contains(",,") || input.startsWith(",") ||
                input.endsWith(","))
            throw new IllegalArgumentException("[ERROR] 부적절한 ,가 포함되어 있습니다.");
    }

    // ,를 기준으로 분리한 배열의 크기가 6인지 검증
    public static void checkValidSize(String input) {
        if (Arrays.asList(input.split(",")).size() != 6)
            throw new IllegalArgumentException("[ERROR] 입력한 로또 번호는 6개여야 합니다.");
    }

    // 입력값이 1이상 45이하인지 검증
    public static void checkNumberIn(int start, int end, Integer number) {
        if (number < start || number > end)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    // 중복입력이 있는지 검증
    public static void checkDuplicated(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++)
                if (numbers.get(i).equals(numbers.get(j)))
                    throw new IllegalArgumentException("[ERROR] 중복된 로또 번호 입력이 존재합니다.");
        }
    }

    // 기존 당첨번호에 존재하는 숫자인지 검증
    public static void checkNumberInList(Integer number, List<Integer> numbers) {
        if (numbers.contains(number))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존 당첨 번호들과 다른 숫자여야 합니다.");
    }
}
