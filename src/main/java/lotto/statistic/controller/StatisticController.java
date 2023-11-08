package lotto.statistic.controller;

import lotto.lotto.dto.LottoDto;
import lotto.statistic.dto.ResultDto;
import lotto.statistic.service.StatisticService;

import java.util.List;

public class StatisticController {

    private StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    public void generate(List<LottoDto> lottoDtos, List<Integer> winningNumbers, int bonusNumber) {
        statisticService.create(lottoDtos, winningNumbers, bonusNumber);
    }

    public ResultDto getResult(int purchaseAmount) {
        return statisticService.getResult(purchaseAmount);
    }
}
