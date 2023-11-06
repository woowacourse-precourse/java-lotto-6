package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utils.constants.ErrorMessageConstants.PICK_NUMBER_ERROR;
import static lotto.utils.constants.ErrorMessageConstants.RANGE_ERROR;
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

    // 아래에 추가 테스트 작성 가능
    @Test
    void 로또_범위_예외_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 48)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGE_ERROR);
    }
    @Test
    void 번호_갯수_예외_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 4, 5, 48)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PICK_NUMBER_ERROR);
    }
}