package lotto.validationTest;

import lotto.Lotto;
import lotto.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
public static void validateInRange(int min, int max, int item) {
    if (!(min <= item && item <= max)) {
        throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
    }
}

public static void validateInRange(int min, int max, List<Integer> lotto) {
    lotto.forEach(i -> {
        validateInRange(min, max, i);
    });
}
*/
public class ValidateInRangeTest {
    @Test
    public void 입력값이_min과_max_사이가_아님_오류있음() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateInRange(0, 10, 15));
    }

    @Test
    public void 입력값이_min과_max_사이_오류없음() {
        Assertions.assertDoesNotThrow(
                () -> Validation.validateInRange(0, 10, 8));
    }

    @Test
    public void 당첨번호의_모든_값이_min과_max_사이가_아님_오류있음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 8, j = 0; j < 6; i++, j++) {
            items.add(i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateInRange(0, 10, items));
    }

    @Test
    public void 당첨번호의_모든_값이_min과_max_사이_오류없음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 8, j = 0; j < 6; i++, j++) {
            items.add(i);
        }
        Assertions.assertDoesNotThrow(
                () -> Validation.validateInRange(0, 999, items));
    }
}
