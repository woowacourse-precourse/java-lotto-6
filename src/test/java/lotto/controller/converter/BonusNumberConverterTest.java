package lotto.controller.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberConverterTest {
    private BonusNumberConverter bonusNumberConverter;

    @BeforeEach
    void setup() {
        bonusNumberConverter = new BonusNumberConverter();
    }

    @Test
    void testConvert() {
        String validBonusNumber = "4";
        int result = bonusNumberConverter.convert(validBonusNumber);
        assertThat(result).isEqualTo(4);
    }
}
