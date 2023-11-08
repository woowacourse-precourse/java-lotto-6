package lotto.statistic.repository;

import lotto.constant.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StatisticRepositoryImplTest {

    StatisticRepository statisticRepository = new StatisticRepositoryImpl();

    @Test
    @DisplayName("Statistic 저장 테스트")
    void saveStatistic() {
        statisticRepository.saveStatistic(Prize.FIFTH);
        statisticRepository.saveStatistic(Prize.FOURTH);
        statisticRepository.saveStatistic(Prize.NONE);

        // 저장된 갯수 확인
        assertThat(statisticRepository.findAll().size()).isEqualTo(3);
        // 저장된 statistic가 동일한지
        assertThat(statisticRepository.findAll().get(1).getPrize().getHitCount()).isEqualTo(4);
    }
}