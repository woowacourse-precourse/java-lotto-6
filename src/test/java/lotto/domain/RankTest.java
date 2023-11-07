package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.config.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[단위 테스트] 당첨 결과")
class RankTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7)
        );
    }

    @DisplayName("1등 당첨 결과를 정확히 계산한다.")
    @Test
    void first_rank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank expected = Rank.FIRST;

        // when
        Rank actual = Rank.of(winningLotto, lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("2등 당첨 결과를 정확히 계산한다")
    @Test
    void second_rank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Rank expected = Rank.SECOND;

        // when
        Rank actual = Rank.of(winningLotto, lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3등 당첨 결과를 정확히 계산한다")
    @Test
    void third_rank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Rank expected = Rank.THIRD;

        // when
        Rank actual = Rank.of(winningLotto, lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("4등 당첨 결과를 정확히 계산한다")
    @Test
    void fourth_rank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Rank expected = Rank.FOURTH;

        // when
        Rank actual = Rank.of(winningLotto, lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5등 당첨 결과를 정확히 계산한다")
    @Test
    void fifth_rank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Rank expected = Rank.FIFTH;

        // when
        Rank actual = Rank.of(winningLotto, lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }


    @DisplayName("당첨 결과가 없을 때의 결과를 정확히 계산한다.")
    @Test
    void no_rank() {
        // given
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Rank expected = Rank.NO_RANK;

        // when
        Rank actual = Rank.of(winningLotto, lotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
