package lotto.Service;


import lotto.controller.LottoController;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsServiceTest {

    StatisticsService statisticsService = new StatisticsService();
    LottoController lottoController = new LottoController();

    @Test
    void 각_등수가_나온_빈도수_구하기() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> num2 = Arrays.asList(1, 2, 3, 11, 12, 13);
        lottos.add(new Lotto(num1));
        lottos.add(new Lotto(num2));

        List<Integer> winningNum = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        // when
        List<Integer> matchCountFrequency = statisticsService.winningStats(lottos, winningNum, bonusNum);

        // then
        assertThat(matchCountFrequency.size()).isEqualTo(8);
        assertThat(matchCountFrequency).containsExactly(0, 0, 0, 1, 0, 0, 0, 1);
    }


    @Test
    void 수익률_구하기() {
        // given
        List<String> reward = lottoController.reward;
        List<Integer> matchCountFrequency = Arrays.asList(16, 7, 4, 2, 1, 0, 0, 0);

        // when
        float returnRate = statisticsService.returnRate(matchCountFrequency, reward);

        // then
        assertThat(returnRate).isEqualTo(200.0f);
    }
}
