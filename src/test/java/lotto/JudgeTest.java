package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {
    Judge judge = new Judge();
    Result result;
    Player player;
    Lotto first, second, third, fourth, fifth, fail;
    Lottos lottos;

    @BeforeEach
    void beforeEach(){
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        second = new Lotto(List.of(1,2,3,4,5,45));
        third = new Lotto(List.of(1,2,3,4,5,10));
        fourth = new Lotto(List.of(1,2,3,4,10,11));
        fifth = new Lotto(List.of(1,2,3,10,11,12));
        fail = new Lotto(List.of(10,11,12,13,14,15));

        player = new Player(playerLotto, 45, 3);

        List<Lotto> lottoList = new ArrayList<>(List.of(first,second,third,fourth,fifth,fail));
        lottos = new Lottos(lottoList);
        result = judge.calculateWinning(player,lottos);
    }

    @DisplayName("FIRST가 맞다")
    @Test
    void firstIsRight(){
        List<Lotto> lottoList1 = new ArrayList<>(List.of(first));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);
        long actual = result.calculateTotalPrize(result1);
        long expected = Reward.FIRST.getPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("SECOND가 맞다")
    @Test
    void secondIsRight(){
        List<Lotto> lottoList1 = new ArrayList<>(List.of(second));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);
        long actual = result.calculateTotalPrize(result1);
        long expected = Reward.SECOND.getPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("THIRD가 맞다")
    @Test
    void thirdIsRight(){
        List<Lotto> lottoList1 = new ArrayList<>(List.of(third));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);
        long actual = result.calculateTotalPrize(result1);
        long expected = Reward.THIRD.getPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("FOURTH가 맞다")
    @Test
    void fourthIsRight(){
        List<Lotto> lottoList1 = new ArrayList<>(List.of(fourth));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);
        long actual = result.calculateTotalPrize(result1);
        long expected = Reward.FOURTH.getPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("FIFTH가 맞다")
    @Test
    void fifthIsRight(){
        List<Lotto> lottoList1 = new ArrayList<>(List.of(fifth));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);
        long actual = result.calculateTotalPrize(result1);
        long expected = Reward.FIFTH.getPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("FAIL가 맞다")
    @Test
    void failIsRight(){
        List<Lotto> lottoList1 = new ArrayList<>(List.of(fail));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);
        long actual = result.calculateTotalPrize(result1);
        long expected = Reward.FAIL.getPrize();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("상금이 올바르게 계산됐다")
    @Test
    void totalPrizeIsRight(){
        long expected = Reward.FIRST.getPrize() + Reward.SECOND.getPrize()+Reward.THIRD.getPrize()+Reward.FOURTH.getPrize()+Reward.FIFTH.getPrize();
        System.out.println(result.getResult());
        long actual = result.calculateTotalPrize(result);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("수익률이 올바르게 계산됐다")
    @Test
    void earningRateIsRight(){
        long expectedPrize = Reward.FIRST.getPrize() + Reward.SECOND.getPrize()+Reward.THIRD.getPrize()+Reward.FOURTH.getPrize()+Reward.FIFTH.getPrize();

        String actual = judge.calculateEarningRate(result,5);
        String expected = String.format("%.1f", ((float) expectedPrize /5000) * 100);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("중복 상금이 올바르게 계산됐다")
    @Test
    void totalPrizeCanBeDuplicate(){
        long expected = Reward.FIRST.getPrize() + Reward.SECOND.getPrize()* 2L;

        List<Lotto> lottoList1 = new ArrayList<>(List.of(first,second,second));
        Lottos computerLotto = new Lottos(lottoList1);
        Result result1 = judge.calculateWinning(player,computerLotto);

        System.out.println(result1.getResult());
        long actual = result1.calculateTotalPrize(result1);

        assertThat(actual).isEqualTo(expected);

    }

}