package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAnswerTest {

    private static LottoAnswer answer;

    @BeforeAll
    private static void beforeAll() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber number = new BonusNumber(7);
        answer = new LottoAnswer(lotto, number);
    }

    @Test
    @DisplayName("로또 번호 등수 계산: 1등")
    void first() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        Rank result = answer.getRankOf(lotto);

        // then
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("로또 번호 등수 계산: 2등")
    void second() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        Rank result = answer.getRankOf(lotto);

        // then
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 번호 등수 계산: 3등")
    void third() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        // when
        Rank result = answer.getRankOf(lotto);

        // then
        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("로또 번호 등수 계산: 4등")
    void fourth() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        // when
        Rank result = answer.getRankOf(lotto);

        // then
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 번호 등수 계산: 5등")
    void fifth() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        // when
        Rank result = answer.getRankOf(lotto);

        // then
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("로또 번호 등수 계산: None")
    void none() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        // when
        Rank result = answer.getRankOf(lotto);

        // then
        assertThat(result).isEqualTo(Rank.NONE);
    }
}