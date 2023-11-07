package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final InputProcessor inputProcessor;

    public LottoController(OutputView outputView, InputView inputView, InputProcessor inputProcessor) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputProcessor = inputProcessor;
    }

    public void start() {

        PaidAmount paidAmount = createPaidAmount();

        LottoIssuer lottoIssuer = new LottoIssuer(new RandomLottoNumberGenerator());
        LottoTickets issuedLottoTickets = lottoIssuer.issue(paidAmount);
        outputView.printIssuedLottoTickets(LottoTicketsDto.from(issuedLottoTickets));

        LottoWinningNumbers lottoWinningNumbers = createLottoWinningNumbers();
        WinningCounts winningCounts = issuedLottoTickets.calculateWinningRanks(new WinningRankCalculator(), lottoWinningNumbers);
        outputView.printWinningCounts(WinningCountsDto.from(winningCounts));

        WinningStatistics winningStatistics = new WinningStatistics(winningCounts, paidAmount);
        outputView.printProfitRate(ProfitRateDto.from(winningStatistics.calculateProfitRate()));
    }

    private PaidAmount createPaidAmount() {
        while (true) {
            try {
                Integer paidAmountInput = inputProcessor.toPaidAmount(inputView.requestPaidAmount());//
                return new PaidAmount(paidAmountInput);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private LottoWinningNumbers createLottoWinningNumbers() {
        while (true) {
            try {
                Lotto winningNumber = createWinningNumber();
                BonusNumber bonusNumber = createBonusNumber();
                return new LottoWinningNumbers(winningNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private Lotto createWinningNumber() {
        while (true) {
            try {
                List<Integer> winningNumbersInput = inputProcessor.toWinningNumbers(inputView.requestWinningNumbers());//
                return new Lotto(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                Integer bonusNumberInput = inputProcessor.toBonusNumber(inputView.requestBonusNumber());//
                return new BonusNumber(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

}
