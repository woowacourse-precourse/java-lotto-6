package lotto.statistic.service;

import lotto.constant.Prize;
import lotto.lotto.dto.LottoDto;
import lotto.statistic.repository.StatisticRepository;

import java.util.Arrays;
import java.util.List;

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
}
