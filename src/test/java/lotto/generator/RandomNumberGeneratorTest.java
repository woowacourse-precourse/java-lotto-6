package lotto.generator;

import static lotto.globar.GlobalConstants.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    void testGenerateUniqueRandomValues() {
        // when
        List<Integer> uniqueRandomValues = RandomNumberGenerator.generateUniqueRandomValues();

        //then
        assertEquals(6, uniqueRandomValues.size());
        assertEquals(uniqueRandomValues.size(), uniqueRandomValues.stream().distinct().count());
        for (Integer value : uniqueRandomValues) {
            assertTrue(value >= LOTTO_STARTING_RANGE && value <= LOTTO_END_RANGE);
        }
    }
}