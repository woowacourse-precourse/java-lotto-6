package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.LottoTickets;
import lotto.model.ProfitCalculator;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistics;
import lotto.view.InputView.InputMessage;
import lotto.view.InputView.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        WinningStatistics winningStatistics = new WinningStatistics();
        ProfitCalculator profitCalculator = new ProfitCalculator();
        WinningNumbers winningNumbers = new WinningNumbers();

        InputView.displayMessage(InputMessage.PRINT_PURCHASE_PRICE);
        int purchasePrice = readPurchasePrice();
        int purchaseAmount = purchasePrice / 1000;

        OutputView.printPurchaseCount(purchaseAmount);
        LottoTickets lottoTickets = new LottoTickets(purchaseAmount);
        OutputView.printLottos(lottoTickets);

        InputView.displayMessage(InputMessage.PRINT_WINNING_NUMBERS);
        Set<Integer> inputWinningNumbers = readWinningNumber();
        winningNumbers.addNumbers(inputWinningNumbers);

        InputView.displayMessage(InputMessage.PRINT_BONUS_NUMBER);
        int inputBonusNumber = readBonusNumber();
        winningNumbers.addBonusNumber(inputBonusNumber);

        winningStatistics.count(lottoTickets, winningNumbers);
        double profit = profitCalculator.calculateProfit(winningStatistics, purchasePrice);
        OutputView.printResult(winningStatistics);
        OutputView.printProfit(profit);
    }

    private int readBonusNumber() {
        while (true) {
            String inputBonusNumber = readLine();
            try {
                return Integer.parseInt(inputBonusNumber);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
                return readBonusNumber();
            }
        }
    }

    private Set<Integer> readWinningNumber() {
        while (true) {
            String inputWinningNumber = readLine();
            try {
                return Arrays.stream(inputWinningNumber.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toCollection(HashSet::new));
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
                return readWinningNumber();
            }
        }
    }

    private int readPurchasePrice() {
        while (true) {
            String inputPurchasePrice = readLine();
            try {
                return Integer.parseInt(inputPurchasePrice);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
                return readPurchasePrice();
            }
        }
    }
}
