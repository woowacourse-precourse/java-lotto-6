package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.service.StatisticsService;
import lotto.utils.Converter;
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

        WinningLotto winningLotto = repeatTemplate(this::initializeWinningLotto);
        showLottoResult(winningLotto, userLottos);
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

    private WinningLotto initializeWinningLotto() {
        Lotto lotto = repeatTemplate(this::generateLotto);
        BonusNumber bonusNumber = repeatTemplate(this::generateBonusNumber);

        return new WinningLotto(lotto, bonusNumber);
    }

    private Lotto generateLotto() {
        String winningNumbers = inputView.inputWinningNumbers();
        List<Integer> numbers = Converter.toIntegerList(winningNumbers);

        return new Lotto(numbers);
    }

    private BonusNumber generateBonusNumber() {
        return new BonusNumber(inputView.inputBonusNumber());
    }

    private void showLottoResult(WinningLotto winningLotto, List<Lotto> userLottos) {
        Map<LottoRanking, Integer> result = statisticsService.checkLottoResult(winningLotto, userLottos);
        double rateOfReturn = statisticsService.calculateRateOfReturn(result, userLottos);

        outputView.printWinningStatistics(result, LottoRanking.findOrder());
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
