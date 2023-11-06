package lotto.domain.valueobject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FormattedNumberTest {
    @DisplayName("숫자에 천 단위 구분자가 제대로 찍히는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1234567, '1,234,567'",
            "1000, '1,000'",
            "5, '5'",
            "123, '123'"
    })
    void getThousandsSeparator_ShouldFormatNumbersWithCommas(int number, String expectedFormatted) {
        FormattedNumber formattedNumber = new FormattedNumber(number);

        String result = formattedNumber.getThousandsSeparator();

        assertThat(result).isEqualTo(expectedFormatted);
    }
}