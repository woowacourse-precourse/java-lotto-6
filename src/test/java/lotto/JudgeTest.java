package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    Reward reward;
    Judge judge = new Judge();
    Result result;

    @BeforeEach
    void beforeEach(){
        result = new Result();
    }



    @DisplayName("결과가 알맞다")
    @Test
    void isResultRight(){
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,10));
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,45,10));
        Lotto lotto4 = new Lotto(List.of(1,2,3,4,10,11));
        Lotto lotto5 = new Lotto(List.of(1,2,3,10,11,12));

        Player player = new Player(playerLotto, 45, 3);

        List<Lotto> lottoList = new ArrayList<>(List.of(lotto1,lotto2,lotto3,lotto4,lotto5));
        Lottos lottos = new Lottos(lottoList);

        result = judge.calculateWinning(player,lottos);
        long expected = Reward.FIRST.getPrize() + Reward.SECOND.getPrize()+Reward.THIRD.getPrize()+Reward.FOURTH.getPrize()+Reward.FIFTH.getPrize();
        long actual = result.calculateTotalPrize(result);

        assertThat(actual).isEqualTo(expected);

    }

}