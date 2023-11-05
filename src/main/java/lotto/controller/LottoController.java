package lotto.controller;

import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.Lotteries;
import lotto.domain.WinningNumber;
import lotto.domain.WinningRank;
import lotto.dto.LotteriesDto;
import lotto.dto.WinningStatisticsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Lotteries lotteries = runRepeat(this::makeLotteries);
        printLotteries(lotteries);

        WinningNumber winningNumber = runRepeat(this::makeWinningNumber);

        WinningStatisticsDto statistics = makeWinningStatistics(lotteries, winningNumber);
        printWinningStatistics(statistics);
    }

    private Lotteries makeLotteries() {
        int purchaseAmount = inputView.readPurchaseAmount();
        return Lotteries.from(purchaseAmount);
    }

    private void printLotteries(Lotteries lotteries) {
        LotteriesDto dto = LotteriesDto.from(lotteries);
        outputView.printLotteries(dto);
    }

    private WinningNumber makeWinningNumber() {
        return inputView.readWinningNumber().toValueObject();
    }

    private WinningStatisticsDto makeWinningStatistics(Lotteries lotteries, WinningNumber winningNumber) {
        Map<WinningRank, Integer> statistics = lotteries.makeWinningStatistics(winningNumber);
        int lottoPrice = lotteries.getLottoPrice();

        return new WinningStatisticsDto(statistics, lottoPrice);
    }

    private void printWinningStatistics(WinningStatisticsDto statistics) {
        outputView.printWinningStatistics(statistics);
    }

    private <T> T runRepeat(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }
}
