package lotto.statistic.repository;

import lotto.constant.Prize;
import lotto.statistic.dto.StatisticDto;

import java.util.List;

public interface StatisticRepository {

    void saveStatistic(Prize prize);

    List<StatisticDto> findAll();
}
