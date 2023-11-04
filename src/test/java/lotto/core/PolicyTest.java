package lotto.core;

import lotto.core.policy.WinningCheckPolicy;
import lotto.core.policy.WinningPolicy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PolicyTest {

    @Test
    void 랜덤_숫자_생성_로직_테스트(){
        //given
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> winning = List.of(7, 6, 5, 4, 3, 2, 1);

        //when
        Integer checkWinning = winningPolicy().winningCount(lotto, winning);

        //then
        assertThat(checkWinning).isEqualTo(lotto.size());
    }

    @Test
    void 랜덤_숫자_생성_로직_아무것도_맞추지_못한_케이스_테스트(){
        //given
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> winning = List.of(8, 9, 10, 11, 12, 13, 14);

        //when
        Integer checkWinning = winningPolicy().winningCount(lotto, winning);

        //then
        assertThat(checkWinning).isZero();
    }

    private static WinningPolicy winningPolicy(){
        return new WinningCheckPolicy();
    }
}
