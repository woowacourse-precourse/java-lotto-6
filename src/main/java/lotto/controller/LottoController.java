package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.Lotteries;
import lotto.domain.Number;
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

        WinningNumber winningNumber = makeWinningNumber();

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
        List<Number> winningNumbers = runRepeat(this::readValidatedWinningNumber);
        Number bonusNumber = runRepeat(() -> readValidatedBonusNumber(winningNumbers));

        return new WinningNumber(winningNumbers, bonusNumber);
    }

    private List<Number> readValidatedWinningNumber() {
        List<Integer> values = inputView.readWinningNumbers();
        List<Number> winningNumbers = Number.getList(values);
        WinningNumber.validate(winningNumbers);
        return winningNumbers;
    }

    private Number readValidatedBonusNumber(List<Number> winningNumbers) {
        int value = inputView.readBonusNumber();
        Number bonusNumber = Number.from(value);
        WinningNumber.validate(winningNumbers, bonusNumber);
        return bonusNumber;
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
