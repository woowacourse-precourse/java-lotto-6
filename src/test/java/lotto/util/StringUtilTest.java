package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void 천단위_구분기호_포맷팅_값이0() {
        // Given
        int number = 0;

        // When
        String formatted = StringUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("0");
    }

    @Test
    public void 천단위_구분기호_포맷팅_음수값() {
        // Given
        int number = -1;

        // When
        String formatted = StringUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("-1");
    }

    @Test
    public void 천단위_구분기호_포맷팅_콤마하나() {
        // Given
        int number = 5000;

        // When
        String formatted = StringUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("5,000");
    }

    @Test
    public void 천단위_구분기호_포맷팅_콤마두개() {
        // Given
        int number = 12345678;

        // When
        String formatted = StringUtil.formatByThousandSeparator(number);

        // Then
        assertThat(formatted).isEqualTo("12,345,678");
    }

    @Test
    public void 문자의_모든_공백_제거() {
        // Given
        String withSpaces = " 1 h e l l o  @   ";

        // When
        String result = StringUtil.deleteAllSpaces(withSpaces);

        // Then
        assertThat(result).isEqualTo("1hello@");
    }
}
