package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 번호의 범위 초과값에 대해 예외가 발생한다.")
    @Test
    void createLottoNumberByOverValue() {
        // given
        int number = LottoConfig.MAX_NUMBER.getValue() + 1;

        // when & then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionMessages.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호의 범위 미만값에 대해 예외가 발생한다.")
    @Test
    void createLottoNumberByUnderValue() {
        // given
        int number = LottoConfig.MIN_NUMBER.getValue() - 1;

        // when & then
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionMessages.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호의 최대값에 대해 예외가 발생하지 않는다.")
    @Test
    void createLottoNumberByMaxValue() {
        // given
        int number = LottoConfig.MAX_NUMBER.getValue();

        // when & then
        Assertions.assertThatCode(() -> new LottoNumber(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호의 최소값에 대해 예외가 발생하지 않는다.")
    @Test
    void createLottoNumberByMinValue() {
        // given
        int number = LottoConfig.MIN_NUMBER.getValue();

        // when & then
        Assertions.assertThatCode(() -> new LottoNumber(number))
                .doesNotThrowAnyException();
    }

}
