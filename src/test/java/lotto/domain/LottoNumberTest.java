package lotto.domain;

import lotto.enums.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(2);
        LottoNumber lottoNumber2 = new LottoNumber("44");
    }

    @DisplayName("1~45 가 아닌 수가 들어 오면 예외 발생")
    @Test
    void createLottoNumberByNonValidRangeNumber() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        assertThatThrownBy(() -> new LottoNumber("46")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
    }

    @DisplayName("수가 아닌 문자가 들어 오면 예외 발생")
    @Test
    void createLottoNumberByNonNumeric() {
        assertThatThrownBy(() -> new LottoNumber("한이삭")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
    }
}