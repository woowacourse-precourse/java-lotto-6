package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

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
        List<Lotto> userLottos = buyLottos();
        outputView.printLottos(toDto(userLottos));

        WinningLotto winningLotto = initializeWinningLotto();

        LottoResult lottoResult = statisticsService.checkLottoResult(winningLotto, userLottos);
        showLottoResult(lottoResult);
    }

    private void showLottoResult(LottoResult lottoResult) {
        LottoResultDto lottoResultDto = toDto(lottoResult);
        double rateOfReturn = statisticsService.calculateRateOfReturn(lottoResult);

        outputView.printWinningStatistics(lottoResultDto);
        outputView.printRateOfResult(rateOfReturn);
    }

    private WinningLotto initializeWinningLotto() {
        String winningNumbers = inputView.inputWinningNumbers();
        List<Integer> numbers = convertToList(winningNumbers);
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningLotto(numbers, bonusNumber);
    }

    private List<Lotto> buyLottos() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        return LottoStore.buyLotto(purchaseAmount);
    }

    private LottoResultDto toDto(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getResult());
    }

    private List<LottoDto> toDto(List<Lotto> userLottos) {
        return userLottos.stream()
                .map(userLotto -> new LottoDto(userLotto.getNumbers()))
                .toList();
    }

    private List<Integer> convertToList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
