package lotto;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ErrorMessage.DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.ErrorMessage.INVALID_LOTTO_FORMAT;
import static lotto.exception.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_FORMAT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPLICATE_LOTTO_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    void createLottoByInvalidSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_FORMAT.getMessage());
    }

    @Test
    @DisplayName("로또 번호 중 하나라도 유효 범위 밖이면 예외가 발생한다.")
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(OUT_OF_RANGE_LOTTO_NUMBERS.getMessage());
    }

}