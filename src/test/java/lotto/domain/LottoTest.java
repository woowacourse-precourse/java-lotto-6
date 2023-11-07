package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개 이상이면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageContaining(ErrorMessage.LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByLowerSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
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

    @Test
    @DisplayName("로또 번호가 중복없이 숫자 범위 내에 6개로 이루어진 경우 에러를 발생시키지 않는다.")
    void validBonusNumber() {
        assertDoesNotThrow(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 45));
        });
    }

}