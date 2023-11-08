package lotto.statistic.service;

import lotto.constant.Prize;
import lotto.lotto.dto.LottoDto;
import lotto.statistic.repository.StatisticRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatisticServiceImplTest {

    StatisticService statisticService = new StatisticServiceImpl(new StatisticRepositoryImpl());

    @Test
    @DisplayName("랜덤 번호와 당첨 번호 비교")
    void compareToWinningNumbersTest() {
        LottoDto lottoDto = new LottoDto();
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        lottoDto.setNumbers(numbers);

        input = "4,5,6,7,8,9";
        List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        assertThat(statisticService.compareToWinningNumbers(lottoDto, winningNumbers)).isEqualTo(3);

    }

    @Test
    @DisplayName("랜덤 번호와 보너스 번호 비교")
    void compareToBonusNumberTest() {
        LottoDto lottoDto = new LottoDto();
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        lottoDto.setNumbers(numbers);

        assertThat(statisticService.compareToBonusNumber(lottoDto, 4)).isEqualTo(true);
        assertThat(statisticService.compareToBonusNumber(lottoDto, 7)).isEqualTo(false);
    }

    @Test
    @DisplayName("당첨 등수 확인 테스트")
    void calculateRankTest() {
        assertThat(statisticService.calculateRank(6, false).getReward()).isEqualTo(Prize.FIRST.getReward());
        assertThat(statisticService.calculateRank(5, true).getReward()).isEqualTo(Prize.SECOND.getReward());
        assertThat(statisticService.calculateRank(5, false).getReward()).isEqualTo(Prize.THIRD.getReward());
        assertThat(statisticService.calculateRank(4, false).getReward()).isEqualTo(Prize.FOURTH.getReward());
        assertThat(statisticService.calculateRank(3, false).getReward()).isEqualTo(Prize.FIFTH.getReward());
        assertThat(statisticService.calculateRank(2, false).getReward()).isEqualTo(Prize.NONE.getReward());
    }
}