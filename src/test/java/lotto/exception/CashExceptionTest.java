package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CashExceptionTest {

    CashException cashException = new CashException();

    @DisplayName("구입 금액에 문자가 들어가면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"8000a", "abc", "100a"})
    void createCashByWord(String cash) {
        assertThatThrownBy(() -> cashException.checkWord(cash))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"900", "14500"})
    void createCashByNotDividedThousand(int cash) {
        assertThatThrownBy(() -> cashException.checkDivision(cash))
                .isInstanceOf(IllegalArgumentException.class);
    };

}
