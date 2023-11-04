package lotto.domain;

import lotto.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageContaining(ErrorMessage.LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .withMessageContaining(ErrorMessage.NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호가 1미만인 경우 예외가 발생한다.")
    @Test
    void createLottoByUnderRangeNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .withMessageContaining(ErrorMessage.NUMBER_OUT_OF_RANGE_LOW.getMessage());
    }

    @DisplayName("로또 번호가 45초과인 경우 예외가 발생한다.")
    @Test
    void createLottoByUpperRangeNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .withMessageContaining(ErrorMessage.NUMBER_OUT_OF_RANGE_HIGH.getMessage());
    }

}