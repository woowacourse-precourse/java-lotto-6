package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNumberTest {
    @ParameterizedTest
    //Given
    @CsvSource(value = {"0", "46"}, delimiter = ',')
    @DisplayName("로또를 구성하는 숫자가 1~45사이가 아니면 에러 발생")
    void LottoNumberInRangeTest(int testNumber) {
        //When & Then
        assertThatThrownBy(() -> LottoNumber.of(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NOT_IN_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또를 구성하는 숫자가 1~45사이면 정상 실행")
    void LottoNumberInRangeTest() {
        //Given
        int testNumber = 10;

        //When & Then
        assertDoesNotThrow(() -> LottoNumber.of(testNumber));
    }
}
