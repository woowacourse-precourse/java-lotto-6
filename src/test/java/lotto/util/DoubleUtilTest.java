package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class DoubleUtilTest {

    @Test
    public void 정수_테스트() {
        // Given
        assertFormattedDouble(0, "0.0");
        assertFormattedDouble(-1, "-1.0");
        assertFormattedDouble(5000, "5,000.0");
        assertFormattedDouble(12345678, "12,345,678.0");
    }

    @Test
    public void 소수_테스트() {
        // Given
        assertFormattedDouble(62.5, "62.5");
        assertFormattedDouble(62.56, "62.6");
        assertFormattedDouble(62.55, "62.5");
    }

    private void assertFormattedDouble(double number, String expected) {
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);
        assertThat(formatted).isEqualTo(expected);
    }
}