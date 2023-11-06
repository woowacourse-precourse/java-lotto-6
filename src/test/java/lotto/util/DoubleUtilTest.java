package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class DoubleUtilTest {

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_값이0일때_소수점생성() {
        // Given
        double number = 0;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("0.0");
    }

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_음수값일때_소수점생성() {
        // Given
        double number = -1;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("-1.0");
    }

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_구분자와_소수점생성() {
        // Given
        double number = 5000;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("5,000.0");
    }

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_구분자2개와_소수점생성() {
        // Given
        double number = 12345678;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("12,345,678.0");
    }

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_변환없는경우() {
        // Given
        double number = 62.5;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("62.5");
    }

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_둘째자리에서_올림되는경우() {
        // Given
        double number = 62.56;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("62.6");
    }

    @Test
    public void 천단위_구분기호_포맷팅과_소수점_첫째자리까지_반올림_둘째자리에서_버림되는경우() {
        // Given
        double number = 62.55;

        // When
        String formatted = DoubleUtil.formatByThousandSeparatorAndRoundUntilFirstDecimal(number);

        // Then
        assertThat(formatted).isEqualTo("62.5");
    }
}
