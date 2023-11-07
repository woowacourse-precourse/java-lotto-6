package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoBonusComparerTest {
    @DisplayName("당첨 번호 리스트와 보너스 번호는 중복되지 않는다.")
    @Test
    public void testCompareMethod() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11);

        int existingNumber = 5;
        assertTrue(LottoBonusComparer.compare(numbers, existingNumber),
                "Expected number " + existingNumber + " to be present in the list");

        int nonExistingNumber = 2;
        assertFalse(LottoBonusComparer.compare(numbers, nonExistingNumber),
                "Expected number " + nonExistingNumber + " to be absent in the list");
    }
}

