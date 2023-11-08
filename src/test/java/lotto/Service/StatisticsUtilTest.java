package lotto.Service;


import lotto.controller.LottoController;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsUtilTest {

    private final StatisticsUtil statisticsUtil = new StatisticsUtil();
    LottoController lottoController = new LottoController();


    @Test
    void 로또_하나와_당첨_번호_비교하기() {
        // given
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(num);

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        // when
        int duplicatedCount = statisticsUtil.getDuplicatedCount(winningNum, bonusNum, lotto);

        // then
        assertThat(duplicatedCount).isEqualTo(6);
    }

    @Test
    void 로또_하나와_당첨_번호_비교하기_2등일때() {
        // given
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(num);

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        // when
        int duplicatedCount = statisticsUtil.getDuplicatedCount(winningNum, bonusNum, lotto);

        // then
        assertThat(duplicatedCount).isEqualTo(7);
    }

    @Test
    void 로또들과_당첨_번호_비교하기() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> num2 = Arrays.asList(1, 2, 3, 11, 12, 13);
        lottos.add(new Lotto(num1));
        lottos.add(new Lotto(num2));

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        // when
        List<Integer> matchCount = statisticsUtil.getMatchCount(lottos, winningNum, bonusNum);

        // then
        assertThat(matchCount).containsExactly(6, 3);
        assertThat(matchCount.size()).isEqualTo(2);
    }

    @Test
    void 총_상금_계산() {
        // given
        List<String> reward = lottoController.reward;
        List<Integer> matchCountFrequency = Arrays.asList(16, 7, 4, 2, 1, 0, 0, 0);

        // when
        Integer totalReward = statisticsUtil.getTotalReward(matchCountFrequency, reward);

        // then
        assertThat(totalReward).isEqualTo(60000);
    }

    @Test
    void 수익률_계산() {
        // given
        List<Integer> matchCountFrequency = Arrays.asList(16, 7, 4, 2, 1, 0, 0, 0);
        Integer totalReward = 60000;

        // when
        float returnRate = statisticsUtil.getReturnRate(matchCountFrequency, totalReward);
        System.out.println("returnRate = " + returnRate);

        // then
        assertThat(returnRate).isEqualTo(200.0f);
    }
}