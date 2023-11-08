package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class ResultTest {

    @Test
    @DisplayName("2등(5개 일치 + 보너스 당첨) 로또가 1개일 때")
    public void createResultWhenSecondIsOne() {
        // given
        Lotto LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos LOTTOS = new Lottos(List.of(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Bonus BONUS = new Bonus(7, LOTTO);

        // when
        Result result = new Result(LOTTO, LOTTOS, BONUS);
        Map<Rank, Integer> store = result.getStore();

        // then
        assertThat(store.get(Rank.SECOND)).isOne();
    }

    @Test
    @DisplayName("2등(5개 일치 + 보너스 당첨) 로또가 1개일 때 당첨금액 확인")
    public void getRewardWhenSecondIsOne() {
        // given
        Lotto LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos LOTTOS = new Lottos(List.of(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Bonus BONUS = new Bonus(7, LOTTO);

        Result result = new Result(LOTTO, LOTTOS, BONUS);
        int expected = Rank.SECOND.getReward();

        // when
        int actual = result.getReward();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등(3개 일치) 로또가 1개일 때")
    public void createResultWhenFifthIsOne() {
        // given
        Lotto LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos LOTTOS = new Lottos(List.of(Arrays.asList(1, 2, 3, 7, 8, 9)));
        Bonus BONUS = new Bonus(10, LOTTO);

        // when
        Result result = new Result(LOTTO, LOTTOS, BONUS);
        Map<Rank, Integer> store = result.getStore();

        // then
        assertThat(store.get(Rank.FIFTH)).isOne();
    }

    @Test
    @DisplayName("5등(3개 일치) 로또가 2개일 때")
    public void createResultWhenFifthIsTwo() {
        // given
        Lotto LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos LOTTOS = new Lottos(List.of(Arrays.asList(1, 2, 3, 7, 8, 9), Arrays.asList(1, 2, 3, 7, 8, 9)));
        Bonus BONUS = new Bonus(10, LOTTO);

        // when
        Result result = new Result(LOTTO, LOTTOS, BONUS);
        Map<Rank, Integer> store = result.getStore();

        // then
        assertThat(store.get(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("2등(5개 일치 + 보너스 당첨) 로또가 1개일 때 당첨금액 확인")
    public void getRewardWhenFifthIsOne() {
        // given
        Lotto LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos LOTTOS = new Lottos(List.of(Arrays.asList(1, 2, 3, 7, 8, 9)));
        Bonus BONUS = new Bonus(10, LOTTO);

        Result result = new Result(LOTTO, LOTTOS, BONUS);
        int expected = Rank.FIFTH.getReward();

        // when
        int actual = result.getReward();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 로또가 없을 때 상금은 0원")
    public void getRewardWhenWinningLottoIsZero() {
        // given
        Lotto LOTTO = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos LOTTOS = new Lottos(List.of(Arrays.asList(7,8,9,10,11,12)));
        Bonus BONUS = new Bonus(13, LOTTO);

        Result result = new Result(LOTTO, LOTTOS, BONUS);

        // when
        int actual = result.getReward();

        // then
        assertThat(actual).isZero();
    }



}