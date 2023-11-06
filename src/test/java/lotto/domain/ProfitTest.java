package lotto.domain;

import static lotto.enums.Prize.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitTest {

    private HashMap<Integer,Integer> rank;

    @BeforeEach
    public void init(){
        rank = new HashMap<>();
        rank.put(FIRST_RANK.getRank(),0);
        rank.put(SECOND_RANK.getRank(),0);
        rank.put(THIRD_RANK.getRank(),0);
        rank.put(FOURTH_RANK.getRank(),0);
        rank.put(FIFTH_RANK.getRank(),0);
    }


    @Test
    @DisplayName("1000원 로또를 구매한경우, 5등 1개가 당첨되면 이익률 500% 반환")
    void 로또_한개_구매_5등_1개_당첨() throws Exception{
        //given
        rank.put(FIFTH_RANK.getRank(),1);
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(500);
    }

    @Test
    @DisplayName("1000원 로또를 구매한경우, 4등 1개가 당첨되면 이익률 5000% 반환")
    void 로또_한개_구매_4등_1개_당첨() throws Exception{
        //given
        rank.put(FOURTH_RANK.getRank(),1);
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(5000);
    }

    @Test
    @DisplayName("1000원 로또를 구매한경우, 3등 1개가 당첨되면 이익률 5000% 반환")
    void 로또_한개_구매_3등_1개_당첨() throws Exception{
        //given
        rank.put(THIRD_RANK.getRank(),1);
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(150000);
    }

    @Test
    @DisplayName("1000원 로또를 구매한경우, 2등 1개가 당첨되면 이익률 5000% 반환")
    void 로또_한개_구매_2등_1개_당첨() throws Exception{
        //given
        rank.put(SECOND_RANK.getRank(),1);
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(3000000);
    }

    @Test
    @DisplayName("1000원 로또를 구매한경우, 1등 1개가 당첨되면 이익률 5000% 반환")
    void 로또_한개_구매_1등_1개_당첨() throws Exception{
        //given
        rank.put(FIRST_RANK.getRank(),1);
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(200000000);
    }

    @Test
    @DisplayName("1000원 로또를 구매한 경우,하나도 당첨되지 않으면 이익률 0% 반환")
    void 로또_한개_구매_당첨_안됨() throws Exception{
        //given
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(0);
    }
}
