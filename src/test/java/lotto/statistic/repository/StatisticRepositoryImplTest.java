package lotto.statistic.repository;

import lotto.constant.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatisticRepositoryImplTest {

    StatisticRepository statisticRepository = new StatisticRepositoryImpl();

    @Test
    @DisplayName("Statistic 저장 테스트")
    void saveStatistic() {
        statisticRepository.saveStatistic(Prize.FIFTH);
        statisticRepository.saveStatistic(Prize.FOURTH);
        statisticRepository.saveStatistic(Prize.NONE);

        assertThat(statisticRepository.findAll().size()).isEqualTo(3);
        assertThat(statisticRepository.findAll().get(1).getPrize().getHitCount()).isEqualTo(4);
    }
}