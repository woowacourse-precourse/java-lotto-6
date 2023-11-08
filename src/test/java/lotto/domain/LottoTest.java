package lotto.domain;

import lotto.type.ErrorMessageType;
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
                .hasMessage(ErrorMessageType.NOT_SIZE_SIX.message());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageType.DUPLICATE_NUMBER.message());
    }

    @DisplayName("로또 번호에 범위에 맞지 않은 숫자가 있으면 예외 발생")
    @Test
    void createLottoByNotInRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(5, 6, 7, 8, 9, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
    }
}