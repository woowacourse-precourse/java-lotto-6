package lotto.controller;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.StatisticsDto;
import lotto.service.RandomNumbers;
import lotto.service.SummaryMatching;
import lotto.service.SummaryMatchingImpl;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoController {
    private final LottosDto lottosDto;
    private final StatisticsDto statisticsDto;

    public LottoController(RandomNumbers randomNumbers, InputView inputView) {
        Lottos lottos = new Lottos(randomNumbers, inputView);
        WinningLotto winningLotto = new WinningLotto(inputView);
        List<Integer> matchingResult = lottos.matchAllLottoWithWinningOne(winningLotto);
        SummaryMatching summaryMatching = new SummaryMatchingImpl(matchingResult);
        this.lottosDto = lottos.toLottosDto();
        this.statisticsDto = summaryMatching.toStatisticsDto();
    }

    public void run() {
        OutputView outputView = new OutputViewImpl();
        outputView.printPurchase(lottosDto);
        outputView.printStatistics(statisticsDto);
    }

}
