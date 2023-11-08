package lotto;

import lotto.domain.Lotto;
import lotto.util.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 리스트의 길이가 6이 아니면 예외가 발생한다.")
    @Test
    void createLottoWithInvalidSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 미만 또는 45 초과인 경우, 예외가 발생한다.")
    @Test
    void createLottoWithInvalidNumberRange() {
        List<Integer> invalidRangeNumbers = List.of(0, 46, 20, 30, 40, 50);
        assertThatThrownBy(() -> new Lotto(invalidRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호가 6개가 아닌 경우, 예외가 발생한다.")
    @Test
    void createLottoWithInvalidNumberCount() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }
}