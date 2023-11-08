package lotto.controller;

import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoGenerator;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.view.OutputView;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.InputView;
import lotto.view.input.MoneyInputView;
import lotto.view.input.WinningNumbersInputView;

public class LottoController {
    private LottoTickets tickets;
    private WinningNumbers winningNumbers;
    private Money money;
    private BonusNumber bonusNumber;

    public void startLottoGame() {
        buyLottoTickets();
        getLottoGameWinningNumbers();
        getLottoBonusNumber();
        printEachLottoResults();
        printLottoTotalReturnRate();
    }

    private void buyLottoTickets() {
        while (true) {
            try {
                InputView inputView = new MoneyInputView();
                money = new Money(inputView.inputMoney());
                int lottoAmount = money.getLottoAmount();
                generateLottoTickets(lottoAmount);
                OutputView.printPurchasedLottoTickets(lottoAmount, tickets);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void generateLottoTickets(int lottoAmount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        tickets = new LottoTickets(lottoGenerator.generateLottoTickets(lottoAmount));
    }

    private void getLottoGameWinningNumbers() {
        while (true) {
            try {
                InputView winningNumbersInputView = new WinningNumbersInputView();
                winningNumbers = new WinningNumbers(winningNumbersInputView.inputWinningNumbers());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void getLottoBonusNumber() {
        while (true) {
            try {
                InputView bonusNumberInputView = new BonusNumberInputView();
                bonusNumber = new BonusNumber(bonusNumberInputView.inputBonusNumber(), winningNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void printEachLottoResults() {
        Map<Integer, Long> eachPrize = tickets.getEachPrize(winningNumbers, bonusNumber);
        OutputView.printEachResults(eachPrize);
    }

    private void printLottoTotalReturnRate() {
        long totalPrize = tickets.getTotalPrize(winningNumbers, bonusNumber);
        double lottoReturnRate = money.calculateReturnRate(totalPrize);
        OutputView.printReturnRate(lottoReturnRate);
    }
}
