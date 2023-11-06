package lotto.controller;

import java.util.function.Consumer;
import java.util.function.Supplier;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;
import lotto.dto.WinningNumbersDto;
import lotto.service.LottoGameService;
import lotto.view.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final LottoGameService lottoGameService;

    public LottoController(InputView inputView, OutputView outputView, InputParser inputParser,
                           LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        getUserInputForLottoGame();
        proceedLottery();
    }

    private void getUserInputForLottoGame() {
        repeatGetUserInput(this::purchaseUserLotto, outputView::printPurchasedLottos);
        repeatGetUserInput(this::determineWinningNumbers, lottoGameService::determineWinningNumbers);
        repeatGetUserInput(this::determineBonusNumber, lottoGameService::determineBonusNumber);
    }

    private LottosDto purchaseUserLotto() {
        outputView.printPurchaseAmount();
        String inputPurchaseAmount = inputView.getUserInput();
        return lottoGameService.purchaseLottos(inputParser.parsePurchaseAmount(inputPurchaseAmount));
    }

    private WinningNumbersDto determineWinningNumbers() {
        outputView.printInputWinningNumbers();
        return inputParser.parseLottoNumbers(inputView.getUserInput());
    }

    private BonusNumberDto determineBonusNumber() {
        outputView.printInputBonusNumber();
        return inputParser.parseBonusNumber(inputView.getUserInput());
    }

    private void proceedLottery() {
        RankResultDto rankResultDto = lottoGameService.calculateRank();
        printResult(rankResultDto);
    }

    private void printResult(RankResultDto rankResultDto) {
        outputView.printRankStatistics();
        outputView.printRankResult(rankResultDto);
        outputView.printTotalReturn(rankResultDto.totalReturn());
    }

    private <T> void repeatGetUserInput(Supplier<T> supplier, Consumer<T> consumer) {
        while (true) {
            try {
                T result = supplier.get();
                consumer.accept(result);
                return;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
