package lotto.controller.lottery;

import lotto.domain.Lotto;
import lotto.lottoenum.LottoRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class lotteryCheckUsingSetTest {
    Lottery lottery;
    Lotto answer;
    Lotto myNum;
    @BeforeEach
    void settingLottery() {
        lottery = new lotteryCheckUsingSet();
    }

    @DisplayName("로또 1등 당첨")
    @Test
    void lottoFirst(){
        answer = new Lotto(List.of(1,2,3,4,5,6));
        myNum = new Lotto(List.of(1,2,3,4,5,6));

        Assertions.assertThat(lottery.lotteryCheck(answer,myNum,9)).isEqualTo(LottoRanking.FIRST);
    }

    @DisplayName("로또 2등 당첨")
    @Test
    void lottoSecond(){
        answer = new Lotto(List.of(1,2,3,4,5,6));
        myNum = new Lotto(List.of(1,2,3,4,5,7));

        Assertions.assertThat(lottery.lotteryCheck(answer,myNum,6)).isEqualTo(LottoRanking.SECOND);
    }

    @DisplayName("로또 3등 당첨")
    @Test
    void lottoThird(){
        answer = new Lotto(List.of(1,2,3,4,5,6));
        myNum = new Lotto(List.of(1,2,3,4,5,9));

        Assertions.assertThat(lottery.lotteryCheck(answer,myNum,22)).isEqualTo(LottoRanking.THIRD);
    }

    @DisplayName("로또 4등 당첨")
    @Test
    void lottoFourth(){
        answer = new Lotto(List.of(1,2,3,4,5,6));
        myNum = new Lotto(List.of(1,2,3,4,9,11));

        Assertions.assertThat(lottery.lotteryCheck(answer,myNum,22)).isEqualTo(LottoRanking.FOURTH);
    }

    @DisplayName("로또 5등 당첨")
    @Test
    void lottoFifth(){
        answer = new Lotto(List.of(1,2,3,4,5,6));
        myNum = new Lotto(List.of(1,2,3,10,11,12));

        Assertions.assertThat(lottery.lotteryCheck(answer,myNum,22)).isEqualTo(LottoRanking.FIFTH);
    }

    @DisplayName("로또 아무것도 당첨 안됬을 경우")
    @Test
    void lottoDefault(){
        answer = new Lotto(List.of(1,2,3,4,5,6));
        myNum = new Lotto(List.of(30,31,32,10,11,12));

        Assertions.assertThat(lottery.lotteryCheck(answer,myNum,22)).isEqualTo(LottoRanking.DEFAULT);
    }
}