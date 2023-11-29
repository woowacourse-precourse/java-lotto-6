package lotto.controller;

import lotto.dto.BuyLottoDto;
import lotto.dto.StatisticsDto;
import lotto.model.Statistics;
import lotto.service.CalculateStatisticService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CalculateStatisticService calculateStatisticService;

    public LottoController(InputView inputView, OutputView outputView,
                           CalculateStatisticService calculateStatisticService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculateStatisticService = calculateStatisticService;
    }

    public void getStatistics(BuyLottoDto buyLottoDto) {
        // 당첨, 보너스 번호 & 로또 번호 비교
        Statistics statistics = buyLottoDto.calculateMatching();

        StatisticsDto statisticsDto = StatisticsDto.createStatisticsDto(statistics);
        outputView.printStatistic(statisticsDto.getStatistics().getResult());

        long totalPrize = calculateStatisticService.calculatePrizeMoney(
                statisticsDto.getStatistics().getResult());// 상금 계산
        outputView.printEarningRate(totalPrize, buyLottoDto.getPurchasePrice());
    }

}
