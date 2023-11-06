package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitTest {
    @Test
    @DisplayName("1000원 로또를 구매한경우, 5등 1개가 당첨되면 이익률 500% 반환")
    void 로또_한개_구매_5등_1개_당첨() throws Exception{
        //given
        final int[] rank = new int[]{0,0,0,0,0,1};
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
        final int[] rank = new int[]{0,0,0,0,1,0};
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
        final int[] rank = new int[]{0,0,0,1,0,0};
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
        final int[] rank = new int[]{0,0,1,0,0,0};
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
        final int[] rank = new int[]{0,1,0,0,0,0};
        final int purchaseMoney = 1000;
        //when
        Profit profit = new Profit(rank);
        //then
        assertThat(profit.getTotalEarningRate(purchaseMoney)).isEqualTo(200000000);
    }
}
