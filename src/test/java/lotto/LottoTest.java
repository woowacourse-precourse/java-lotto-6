package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    final Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
    WinningLotto winningLotto;

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

    @DisplayName("로또의 정형화된 배열 형태 출력")
    @Test
    void formatString() {
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]",
                new Lotto(List.of(1,2,3,4,5,6)).formatString());
    }

    @DisplayName("로또의 정형화된 배열 형태 출력")
    @Test
    void rankFind() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        winningLotto = WinningLotto.of(List.of(1,2,3,4,5,6),7);

        Assertions.assertEquals(lotto.getMyRank(winningLotto), LottoRank.FIRST);
    }

}