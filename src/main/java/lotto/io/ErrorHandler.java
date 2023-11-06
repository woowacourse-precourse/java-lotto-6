package lotto.io;

import java.util.Collections;
import java.util.List;

public class ErrorHandler {
    public static void checkInt(String boughtAmount) {
        if (!boughtAmount.matches("-?\\d+")) {
            throw new IllegalArgumentException("Error! 입력값은 Integer 여야 합니다");
        }
    }

    public static void checkPositive(String boughtAmount) {
        int boughtAmountInt = Integer.parseInt(boughtAmount);
        if (boughtAmountInt < 0) {
            throw new IllegalArgumentException("Error! 입력값은 양수 여야 합니다.");
        }
    }

    public static void checkThousands(String boughtAmount) {
        int boughtAmountInt = Integer.parseInt(boughtAmount);
        if (boughtAmountInt % 1000 != 0) {
            throw new IllegalArgumentException("Error! 1000 단위로 입력해야 합니다.");
        }
    }

    public static void validateRepeat(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (Collections.frequency(numbers, i) > 1) {
                throw new IllegalArgumentException("Error! 각 로또번호는 unique 해야 합니다");
            }
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException("Error! 각 로또번호는 1~45사이 여야 합니다.");
            }
        }
    }

    public static void checkSize(List<String> jackpotStrings) {
        if (jackpotStrings.size() != 7) {
            throw new IllegalArgumentException("Error! 입력한 번호가 부족합니다.");
        }
    }
}
