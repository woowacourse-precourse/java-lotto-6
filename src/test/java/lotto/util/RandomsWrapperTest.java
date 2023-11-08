package lotto.util;

import lotto.config.LottoConstants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomsWrapperTest {

    @Test
    public void testPickLottoNumberInRange() {
        // Arrange
        RandomNumberGenerator generator = new RandomsWrapper();

        // Act
        List<Integer> lottoNumbers = generator.pickLottoNumberInRange();

        // Assert
        assertEquals(LottoConstants.LOTTO_SIZE.getValue(), lottoNumbers.size());

        for (int number : lottoNumbers) {
            assertTrue(number >= LottoConstants.LOTTO_MIN_NUMBER.getValue() && number <= LottoConstants.LOTTO_MAX_NUMBER.getValue());
        }
    }
}
