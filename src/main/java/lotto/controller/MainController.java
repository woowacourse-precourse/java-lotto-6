package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.StatisticsService;
import lotto.utils.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
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
        outputView.printLottos(toDto(userLottos));

        WinningLotto winningLotto = repeatTemplate(this::initializeWinningLotto);

        LottoResult lottoResult = statisticsService.checkLottoResult(winningLotto, userLottos);
        showLottoResult(lottoResult);
    }

    private List<Lotto> buyLottos() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        return LottoStore.buyLotto(purchaseAmount);
    }

    private List<LottoDto> toDto(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(userLotto -> new LottoDto(userLotto.getNumbers()))
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
        int inputBonusNumber = inputView.inputBonusNumber();
        return new BonusNumber(inputBonusNumber);
    }

    private void showLottoResult(LottoResult lottoResult) {
        LottoResultDto lottoResultDto = toDto(lottoResult);
        double rateOfReturn = statisticsService.calculateRateOfReturn(lottoResult);

        outputView.printWinningStatistics(lottoResultDto);
        outputView.printRateOfResult(rateOfReturn);
    }

    private LottoResultDto toDto(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getResult());
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
