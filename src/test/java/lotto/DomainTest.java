package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class DomainTest {
    Domain domain;
    int bonus;
    List<Integer> winningNums;

    @BeforeEach
    void setUp(){
        domain = new Domain();
        bonus = 7;
        winningNums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void 순위를_적절하게_반환하는지_확인(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Rank rank = domain.ranking(winningNums,bonus,lotto);
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    void 순위들을_적절하게_반환했는지_확인(){
        LottoMarketService lottoMarketService = new LottoMarketService();
        List<Lotto> lottoes = new ArrayList<>();
        lottoes.add(new Lotto(Arrays.asList(1,2,3,4,5,7)));
        lottoes.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottoes.add(new Lotto(Arrays.asList(7,8,10,1,2,3)));
        lottoes.add(new Lotto(Arrays.asList(5,6,7,8,9,10)));

        Map<Rank,Integer> rankingResult = domain.allRanking(winningNums,bonus,lottoes);

        Assertions.assertThat(rankingResult).contains(
                Assertions.entry(Rank.FIRST_PLACE,1)
                ,Assertions.entry(Rank.SECOND_PLACE,1)
                ,Assertions.entry(Rank.FIFTH_PLACE,1)
                ,Assertions.entry(Rank.NOT_WIN,1));
    }

    @Test
    void 수익금을_제대로_계산했는지_확인(){
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIRST_PLACE);
        ranks.add(Rank.SECOND_PLACE);
        ranks.add(Rank.FIFTH_PLACE);

        int profit = domain.calculateProfit(ranks);

        Assertions.assertThat(profit)
                .isEqualTo(2030005000);
    }

    @Test
    void 수익률을_제대로_반환하는지_확인(){
        double percent = domain.calculatePercent(6000,50000);
        Assertions.assertThat(percent).isEqualTo(833.3);
    }

}