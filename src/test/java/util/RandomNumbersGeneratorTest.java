package util;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RandomNumbersGeneratorTest {
    RandomNumberGeneratorUtil randomNumberGeneratorUtil = new RandomNumberGeneratorUtil();

    @Test
    public void testRandomNumbersGenerateListType() {
        List<Integer> randomNumbers = randomNumberGeneratorUtil.randomNumbersGenerate();
        assertTrue(randomNumbers instanceof List);
    }

    @Test
    public void testRandomNumbersGenerateSize() {
        List<Integer> randomNumbers = randomNumberGeneratorUtil.randomNumbersGenerate();
        assertEquals(6, randomNumbers.size());
    }

    @Test
    public void testRandomNumbersGenerateRange() {
        List<Integer> randomNumbers = randomNumberGeneratorUtil.randomNumbersGenerate();
        for (Integer number : randomNumbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    public void testRandomNumbersGenerateAscendingOrder() {
        List<Integer> randomNumbers = randomNumberGeneratorUtil.randomNumbersGenerate();
        for (int i = 0; i < randomNumbers.size() - 1; i++) {
            assertTrue(randomNumbers.get(i) < randomNumbers.get(i + 1));
        }
    }
}
