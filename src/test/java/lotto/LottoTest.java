package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @DisplayName("로또 번호의 개수가 6개가 넘고 중복된 숫자가 포함되면 개수에 대한 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumberAndOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class getSameNumberCount_메서드는 {

        static List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        @Test
        void 동일한_숫자가_존재하지않으면_0을_리턴한다() {
            Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(0);
        }

        @Test
        void 동일한_숫자가_1개_존재하면_1을_리턴한다() {
            Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 6));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(1);
        }

        @Test
        void 동일한_숫자가_2개_존재하면_2를_리턴한다() {
            Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 5, 6));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(2);
        }

        @Test
        void 동일한_숫자가_3개_존재하면_3을_리턴한다() {
            Lotto lotto = new Lotto(List.of(7, 4, 9, 10, 5, 6));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(3);
        }

        @Test
        void 동일한_숫자가_4개_존재하면_4를_리턴한다() {
            Lotto lotto = new Lotto(List.of(3, 4, 9, 10, 5, 6));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(4);
        }

        @Test
        void 동일한_숫자가_5개_존재하면_5를_리턴한다() {
            Lotto lotto = new Lotto(List.of(3, 4, 2, 10, 5, 6));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(5);
        }

        @Test
        void 동일한_숫자가_6개_존재하면_6을_리턴한다() {
            Lotto lotto = new Lotto(List.of(3, 4, 2, 1, 5, 6));
            Assertions.assertThat(lotto.getSameNumberCount(winningNumbers)).isEqualTo(6);
        }
    }

    @Nested
    class getResult_메서드는 {

        static List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        static int bonusNumber = 7;
        static WinningLotto winningLotto;

        @Test
        void 동일한_숫자가_존재하지않으면_NONE을_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.NONE);
        }

        @Test
        void 동일한_숫자가_1개_존재하면_NONE을_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.NONE);
        }

        @Test
        void 동일한_숫자가_2개_존재하면_NONE를_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(11, 8, 9, 10, 5, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.NONE);
        }

        @Test
        void 동일한_숫자가_3개_존재하면_FIFTH을_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(7, 4, 9, 10, 5, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.FIFTH);
        }

        @Test
        void 동일한_숫자가_4개_존재하면_FOURTH를_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(3, 4, 9, 10, 5, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.FOURTH);
        }

        @Test
        void 동일한_숫자가_5개_존재하면_THIRD를_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(3, 4, 2, 10, 5, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.THIRD);
        }

        @Test
        void 동일한_숫자가_5개_존재하고_보너스_숫자를_포함하면_SECOND를_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(3, 4, 2, 7, 5, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.SECOND);
        }
        @Test
        void 동일한_숫자가_6개_존재하면_FIRST을_리턴한다() {
            winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            Lotto lotto = new Lotto(List.of(3, 4, 2, 1, 5, 6));
            Assertions.assertThat(lotto.getResult(winningLotto)).isEqualTo(Score.FIRST);
        }
    }

}