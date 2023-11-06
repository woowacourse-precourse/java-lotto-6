package lotto.controller;

import lotto.converter.Converter;
import lotto.converter.StringToIntegerListConverter;
import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StatisticsService statisticsService;

    public MainController(InputView inputView, OutputView outputView, StatisticsService statisticsService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.statisticsService = statisticsService;
    }

    public void run() {
        List<Lotto> userLottos = repeatTemplate(this::buyLottos);
        showUserLottos(userLottos);

        LottoResult lottoResult = checkLottoResultOf(userLottos);
        showLottoResult(lottoResult, userLottos);
    }

    private List<Lotto> buyLottos() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        return LottoStore.buyLotto(purchaseAmount);
    }

    private void showUserLottos(List<Lotto> userLottos) {
        outputView.printLottos(toDto(userLottos));
    }

    private List<LottoDto> toDto(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    private LottoResult checkLottoResultOf(List<Lotto> userLottos) {
        WinningLotto winningLotto = repeatTemplate(this::initializeWinningLotto);

        return statisticsService.checkLottoResult(winningLotto, userLottos);
    }

    private WinningLotto initializeWinningLotto() {
        Lotto lotto = repeatTemplate(this::generateLotto);
        BonusNumber bonusNumber = repeatTemplate(this::generateBonusNumber);

        return new WinningLotto(lotto, bonusNumber);
    }

    private Lotto generateLotto() {
        Converter<String, List<Integer>> converter = new StringToIntegerListConverter();

        String winningNumbers = inputView.inputWinningNumbers();
        List<Integer> numbers = converter.convert(winningNumbers);

        return new Lotto(numbers);
    }

    private BonusNumber generateBonusNumber() {
        int inputBonusNumber = inputView.inputBonusNumber();
        return new BonusNumber(inputBonusNumber);
    }

    private void showLottoResult(LottoResult lottoResult, List<Lotto> userLottos) {
        showWinningStatistics(lottoResult);
        showRateOrReturn(lottoResult, userLottos);
    }

    private void showWinningStatistics(LottoResult lottoResult) {
        Map<LottoRanking, Integer> result = lottoResult.getResult();
        List<LottoRanking> lottoRankingOutputOrder = LottoRanking.findOrder();

        outputView.printWinningStatistics(result, lottoRankingOutputOrder);
    }

    private void showRateOrReturn(LottoResult lottoResult, List<Lotto> userLottos) {
        double rateOfReturn = statisticsService.calculateRateOfReturn(lottoResult, userLottos);
        outputView.printRateOfResult(rateOfReturn);
    }

    private <T> T repeatTemplate(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatTemplate(inputReader);
        }
    }
}
