package lotto.controller;

import java.util.function.Consumer;
import java.util.function.Supplier;
import lotto.dto.RankResultDto;
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
        purchaseLottos();
        determineWinningNumbers();
        determineBonusNumber();
        RankResultDto rankResultDto = lottoGameService.calculateRank();
        outputView.printRankStatistics();
        outputView.printRankResult(rankResultDto);
        outputView.printTotalReturn(rankResultDto.totalReturn());
    }

    private void purchaseLottos() {
        handleInputProcess(
                () -> {
                    outputView.printPurchaseAmount();
                    String inputPurchaseAmount = inputView.getUserInput();
                    return lottoGameService.purchaseLottos(inputParser.parsePurchaseAmount(inputPurchaseAmount));
                },
                outputView::printPurchasedLottos
        );
    }

    private void determineWinningNumbers() {
        handleInputProcess(
                () -> {
                    outputView.printInputWinningNumbers();
                    return inputParser.parseLottoNumbers(inputView.getUserInput());
                },
                lottoGameService::determineWinningNumbers
        );
    }

    private void determineBonusNumber() {
        handleInputProcess(
                () -> {
                    outputView.printInputBonusNumber();
                    return inputParser.parseBonusNumber(inputView.getUserInput());
                },
                lottoGameService::determineBonusNumber
        );
    }

    private <T> void handleInputProcess(Supplier<T> supplier, Consumer<T> consumer) {
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
