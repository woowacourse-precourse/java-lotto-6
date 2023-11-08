package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.global.Prize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호에 범위 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또를 비교하여 등수를 확인한다.")
    @Test
    void checkLottoRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.compare(List.of(1, 2, 3, 4, 5, 6), 7))
                .isEqualTo(Prize.FIRST);
        assertThat(lotto.compare(List.of(1, 2, 3, 4, 5, 7), 7))
                .isEqualTo(Prize.SECOND);
        assertThat(lotto.compare(List.of(1, 2, 3, 4, 5, 8), 7))
                .isEqualTo(Prize.THIRD);
        assertThat(lotto.compare(List.of(1, 2, 3, 4, 8, 9), 7))
                .isEqualTo(Prize.FORTH);
        assertThat(lotto.compare(List.of(1, 2, 3, 7, 8, 9), 7))
                .isEqualTo(Prize.FIFTH);
    }
}