package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    public static void validateInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 이루어진 문자가 아닙니다.");
        }
    }

    public static void validateOnlyNumber(String str) {
        if (!str.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자로만 이루어진 문자가 아닙니다.");
        }
    }

    public static void validateThousandMultiple(int number) {
        if ((number % 1000) != 0) {
            throw new IllegalArgumentException("1000단위로 이루어진 숫자가 아닙니다.");
        }
    }

    public static void validateMoreThan1000(int number) {
        if (number < 1000) {
            throw new IllegalArgumentException("1000 이상의 숫자가 아닙니다.");
        }
    }

    public static void validateDuplicateNumbers(String[] numbers) {
        List<Integer> mappedNumbers = Arrays.stream(numbers)
                .mapToInt(str -> Integer.parseInt(str))
                .boxed()
                .collect(Collectors.toList());
        Set<Integer> nonDuplicateNumbers = new HashSet<>(mappedNumbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("번호들은 중복 될 수 없습니다.");
        }
    }

    public static void validateContainComma(String str) {
        if (!str.contains(",")) {
            throw new IllegalArgumentException("컴마가 들어있지 않습니다.");
        }
    }

    public static void validate1To45Numbers(String[] numbers) {
        boolean is1To45 = Arrays.stream(numbers)
                .allMatch(number -> Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45);
        if (!is1To45) {
            throw new IllegalArgumentException("1~45사이의 숫자가 아닙니다.");
        }
    }

    public static void validate1To45Number(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("1~45사이의 숫자가 아닙니다.");
        }
    }

    public static void validateDuplicateBonusNumber(List<Integer> answerNumbers, int bonusNumber) {
        if (answerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호 중 보너스 번호와 중복되는 번호가 있습니다.");
        }
    }


}
