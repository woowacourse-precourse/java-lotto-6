package lotto.statistic.service;

import lotto.constant.Prize;
import lotto.lotto.dto.LottoDto;
import lotto.statistic.dto.ResultDto;
import lotto.statistic.dto.StatisticDto;
import lotto.statistic.repository.StatisticRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public void create(List<LottoDto> lottoDtos, List<Integer> winningNumbers, int bonusNumber) {
        for (LottoDto lottoDto : lottoDtos) {
            statisticRepository.saveStatistic(calculateRank(compareToWinningNumbers(lottoDto, winningNumbers), compareToBonusNumber(lottoDto, bonusNumber)));
        }
    }

    @Override
    public Prize calculateRank(int hitWinningNumbersCount, boolean hitBonusNumberCount) {
        return Arrays.stream(Prize.values())
                .filter(rank -> rank.find(hitWinningNumbersCount, hitBonusNumberCount))
                .findFirst()
                .orElse(Prize.NONE);
    }

    @Override
    public int compareToWinningNumbers(LottoDto lottoDto, List<Integer> winningNumbers) {
        return (int) lottoDto.getNumbers()
                .stream()
                .filter(winningNumbers::contains).count();
    }

    @Override
    public boolean compareToBonusNumber(LottoDto lottoDto, int bonusNumber) {
        return lottoDto.getNumbers().contains(bonusNumber);
    }

    @Override
    public ResultDto getResult(int purchaseAmount) {
        int[] ranks = new int[Prize.values().length];
        List<StatisticDto> statisticDtos = statisticRepository.findAll();
        double revenue = 0;
        for (StatisticDto statisticDto : statisticDtos) {
            ranks[statisticDto.getPrize().ordinal()]++;
            revenue += statisticDto.getPrize().getReward();
        }
        revenue /= purchaseAmount;
        revenue = (Math.round(revenue * 10000) / 100.0);
        return new ResultDto(Arrays.stream(ranks).boxed().collect(Collectors.toList()), revenue);
    }
}
