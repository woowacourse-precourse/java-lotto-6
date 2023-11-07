package lotto.domain;

import static common.ErrorCode.WINNING_NUMBER_INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨 번호 검증")
class WinningNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 당첨_번호_1미만_45초과_예외(int number) {
        // when
        // then
        assertThatThrownBy(() -> new WinningNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBER_INVALID_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 당첨_번호_생성(int number) {
        // when
        WinningNumber result = new WinningNumber(number);

        // then
        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void 로또_번호_비교_검증(int number, boolean expected) {
        // given
        WinningNumber winningNumber = new WinningNumber(1);

        // when
        boolean result = winningNumber.equalsTo(number);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
