package lotto.lotto;

import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_COUNT_NOT_MATCH;
import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.error.message.InvalidStateErrorMessage.LOTTO_NUMBERS_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.exception.InvalidStateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidStateException.class)
                .extracting("message")
                .isEqualTo(LOTTO_NUMBERS_COUNT_NOT_MATCH.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(InvalidStateException.class)
                .extracting("message")
                .isEqualTo(LOTTO_NUMBERS_DUPLICATE.getMessage());
    }

    @DisplayName("로또에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(InvalidStateException.class)
                .extracting("message")
                .isEqualTo(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
    }
}