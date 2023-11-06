package lotto.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import lotto.domain.Draw;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createDrawByOverSize() {
        assertThatThrownBy(() -> new Draw(List.of(1, 2, 3, 4, 5, 6, 7), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Draw(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new Draw(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 입력에서는 로또의 순위 리스트를 반환한다.")
    @Test
    void createDraw() {
        Draw draw = new Draw(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        List<Rank> ranks = draw.doDraw(lottos);

        Assertions.assertDoesNotThrow(() -> ranks.get(0));
        Assertions.assertEquals(ranks.get(0), Rank.FIRST);
    }
}