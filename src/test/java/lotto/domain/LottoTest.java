package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("구매자의 로또 번호와 당첨 번호를 비교하여 당첨 통계를 계산한다.")
    class judgeLottoRank {

        @Test
        @DisplayName("번호 0개가 맞으면 MISS를 반환한다.")
        void return_MISS_Rank() {
            Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
            BonusNumber bonusNumber = new BonusNumber(45);

            WinningStatistics winningStatistics = buyerLotto.judgeLottoRank(winningLotto, bonusNumber);

            assertEquals(winningStatistics, WinningStatistics.MISS);
        }

        @Test
        @DisplayName("번호 3개가 맞으면 5등을 반환한다.")
        void return_FIFTH_Rank() {
            Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
            BonusNumber bonusNumber = new BonusNumber(7);

            WinningStatistics winningStatistics = buyerLotto.judgeLottoRank(winningLotto, bonusNumber);

            assertEquals(winningStatistics, WinningStatistics.FIFTH);
        }

        @Test
        @DisplayName("번호 4개가 맞으면 4등을 반환한다.")
        void return_FOURTH_Rank() {
            Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
            BonusNumber bonusNumber = new BonusNumber(7);

            WinningStatistics winningStatistics = buyerLotto.judgeLottoRank(winningLotto, bonusNumber);

            assertEquals(winningStatistics, WinningStatistics.FOURTH);
        }

        @Test
        @DisplayName("번호 5개가 맞으면 3등을 반환한다.")
        void return_THIRD_Rank() {
            Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
            BonusNumber bonusNumber = new BonusNumber(7);

            WinningStatistics winningStatistics = buyerLotto.judgeLottoRank(winningLotto, bonusNumber);

            assertEquals(winningStatistics, WinningStatistics.THIRD);
        }

        @Test
        @DisplayName("번호 5개의 보너스 번호 1개 맞으면 2등을 반환한다.")
        void return_SECOND_Rank() {
            Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(9);

            WinningStatistics winningStatistics = buyerLotto.judgeLottoRank(winningLotto, bonusNumber);

            assertEquals(winningStatistics, WinningStatistics.SECOND);
        }

        @Test
        @DisplayName("번호 6개가 다 맞으면 1등을 반환한다.")
        void return_FIRST_Rank() {
            Lotto buyerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);

            WinningStatistics winningStatistics = buyerLotto.judgeLottoRank(winningLotto, bonusNumber);

            assertEquals(winningStatistics, WinningStatistics.FIRST);
        }
    }
}
