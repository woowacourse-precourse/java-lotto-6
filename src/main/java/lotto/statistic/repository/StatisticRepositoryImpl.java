package lotto.statistic.repository;

import lotto.constant.Prize;
import lotto.statistic.dto.StatisticDto;
import lotto.statistic.entity.Statistic;

import java.util.ArrayList;
import java.util.List;

public class StatisticRepositoryImpl implements StatisticRepository {

    private final List<Statistic> statistics = new ArrayList<>();

    @Override
    public void saveStatistic(Prize prize) {
        Statistic statistic = new Statistic(prize);
        statistics.add(statistic);
    }

    @Override
    public List<StatisticDto> findAll() {
        List<StatisticDto> statisticDtos = new ArrayList<>();
        for (Statistic statistic : statistics) {
            statisticDtos.add(new StatisticDto(statistic.getPrize()));
        }
        return statisticDtos;
    }
}
