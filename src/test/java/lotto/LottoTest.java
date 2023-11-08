package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Error.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_SIZE.getErrMsg());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBERS.getErrMsg());
    }

    @DisplayName("로또 번호에 46이상의 숫자가있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidedNumber_01() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 98)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_VALUE.getErrMsg());
    }

    @DisplayName("로또 번호에 1이하의 숫자가있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidedNumber_02() {
        assertThatThrownBy(() -> new Lotto(List.of(-5, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_VALUE.getErrMsg());
    }
}