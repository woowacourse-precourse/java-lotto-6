package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호 일치 계산 결과 1등(6개)")
    @Test
    void compareAndResultFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        Rank expectedRank = lotto.compareWithWinningNumbers(winningLotto);

        assertThat(expectedRank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("번호 일치 계산 결과 2등(5개+보너스)")
    @Test
    void compareAndResultSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 6, 7));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        Rank expectedRank = lotto.compareWithWinningNumbers(winningLotto);

        assertThat(expectedRank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("번호 일치 계산 결과 3등(5개)")
    @Test
    void compareAndResultThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 16));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        Rank expectedRank = lotto.compareWithWinningNumbers(winningLotto);

        assertThat(expectedRank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("번호 일치 계산 결과 4등(4개)")
    @Test
    void compareAndResultFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 16));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        Rank expectedRank = lotto.compareWithWinningNumbers(winningLotto);

        assertThat(expectedRank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("번호 일치 계산 결과 5등(3개)")
    @Test
    void compareAndResultFifth() {
        Lotto lotto = new Lotto(List.of(1, 12, 3, 14, 5, 16));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        Rank expectedRank = lotto.compareWithWinningNumbers(winningLotto);

        assertThat(expectedRank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("번호 일치 계산 결과 탈락")
    @Test
    void compareAndResultNone() {
        Lotto lotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6, 7);
        Rank expectedRank = lotto.compareWithWinningNumbers(winningLotto);

        assertThat(expectedRank).isEqualTo(Rank.NONE);
    }
}