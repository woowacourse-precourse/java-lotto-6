package lotto.io;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ErrorHandler {
    public static void checkInt(String boughtAmount) {
        if (!boughtAmount.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    public static void checkPositive(String boughtAmount) {
        int boughtAmountInt = Integer.parseInt(boughtAmount);
        if (boughtAmountInt < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE.getMessage());
        }
    }

    public static void checkThousands(String boughtAmount) {
        int boughtAmountInt = Integer.parseInt(boughtAmount);
        if (boughtAmountInt % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSANDS.getMessage());
        }
    }

    public static void validateRepeat(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (Collections.frequency(numbers, i) > 1) {
                throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE.getMessage());
            }
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
            }
        }
    }

    public static void checkSize(List<String> jackpotStrings) {
        if (jackpotStrings.size() != 7) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getMessage());
        }
    }
}
