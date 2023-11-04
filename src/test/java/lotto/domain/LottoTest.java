package lotto.domain;

import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_SIZE_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATION_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("로또 번호에 최대 로또 번호 보다 큰 번호가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByExceedMaxNumber() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("로또 번호에 최소 로또 번호 보다 작은 번호가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByUnderMinNumber() {
        // given
        List<Integer> numbers = List.of(1, 0, 3, 4, 5, 10);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
    }

}