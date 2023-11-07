package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PrizePercentageTest {

    @DisplayName("double 값을 소수점 둘째 자리에서 반올림해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"92.1555:92.2%", "92.1444:92.1%", "100.0000:100.0%"}, delimiter = ':')
    void printNumberRoundToTwoDecimalPlace(double number, String result) {
        PrizePercentage prizePercentage = new PrizePercentage(number);

        assertThat(prizePercentage.getPrizePercentage()).isEqualTo(result);
    }
}