package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class IntegerUtilTest {

    @Test
    public void 천단위_구분기호_포맷팅_값이0() {
        // Given
        int number = 0;

        // When
        String formatted = IntegerUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("0");
    }

    @Test
    public void 천단위_구분기호_포맷팅_음수값() {
        // Given
        int number = -1;

        // When
        String formatted = IntegerUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("-1");
    }

    @Test
    public void 천단위_구분기호_포맷팅_콤마하나() {
        // Given
        int number = 5000;

        // When
        String formatted = IntegerUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("5,000");
    }

    @Test
    public void 천단위_구분기호_포맷팅_콤마두개() {
        // Given
        int number = 12345678;

        // When
        String formatted = IntegerUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("12,345,678");
    }

}