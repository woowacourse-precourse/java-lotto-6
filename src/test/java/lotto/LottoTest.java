package lotto;

import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 범위를 넘어간 숫자가 있으면 예외 발생")
    @Test
    void createLottoOverRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 66, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("숫자가 포함되어 있다면 true 반환")
    @Test
    void isContainNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int containNumber = 3;
        int notContain = 33;

        assertTrue(lotto.isContain(containNumber));
        assertFalse(lotto.isContain(notContain));
    }

    @DisplayName("포함된 숫자의 개수가 3개일 경우 반환 테스트")
    @Test
    void matchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(3, 4, 5, 23, 33, 42));

        assertThat(lotto.matchCount(otherLotto)).isEqualTo(3);
    }

}