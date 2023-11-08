package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class NumberOfLottoTicketsTest {
    @ParameterizedTest
    @CsvSource(value = {"5000,5", "10000,10", "12000,12", "3000,3", "55000,55"})
    void publishLotto(int money, int expected) {
        int result = money / 1000;
        assertThat(result).isEqualTo(expected);
    }

}