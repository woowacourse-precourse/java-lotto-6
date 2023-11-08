package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateUtil {

    public static int toNumeric(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static List<Integer> stringToArrayList(String inputNumbers) {
        try {
            return Arrays.stream(inputNumbers.split(",")).map(ValidateUtil::toNumeric)
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함 되어있습니다.");
        }
    }

    public static void isInRange(int number, int startRange, int endRange) {
        if (number < startRange || number > endRange) {
            throw new IllegalArgumentException(String.format("[ERROR] %d 이상 %d 이하의 값을 입력 하세요", startRange, endRange));
        }
    }
}
