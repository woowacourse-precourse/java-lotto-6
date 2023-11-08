package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RevenueTest {

    @DisplayName("소수점 두번째에서 반올림 후 한자리까지 나타낸다.")
    @ParameterizedTest
    @CsvSource(value = {"0.6256|62.6", "3.110|311.0", "0.0|0.0", "1.0|100.0", "0.5444|54.4"}, delimiterString = "|")
    void checkFormat(Double number, String expected) {
        Revenue revenue = new Revenue(number);
        String percentage = revenue.getPercentage();
        assertThat(percentage).isEqualTo(expected);
    }
}
