package lotto;

import lotto.domain.Customer;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoSeller;
import lotto.domain.WinningNumbers;
import lotto.util.InputUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    Customer customer = new Customer();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    WinningNumbers winningNumbers = new WinningNumbers();

    public void purchaseLotto() {
        try {
            inputView.requestMoneyMessage();
            customer.scanPocket(InputUtil.getUserInput());
            LottoSeller seller = new LottoSeller();
            seller.checkRemainder(customer.getMoney());
            outputView.printLottoCount(seller.getSellCount());
            customer.setLotteryTicket(seller.makeLottoTickets());
            outputView.printLottoNumbers(customer.getLotteryTicket());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }
    }

    public void generateWinningNumbers() {
        try {
            inputView.requestWinningNumberMessage();
            winningNumbers.makeWinningNumber(InputUtil.getUserInput());
            inputView.requestBonusNumberMessage();
            winningNumbers.makeBonusNumber(InputUtil.getUserInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateWinningNumbers();
        }
    }

    public void revealLottoResults() {
        outputView.printResultMessage();
        LottoCalculator calculator = new LottoCalculator(winningNumbers);
        calculator.makePrizeResult(customer.getLotteryTicket());
        outputView.printPrizeResult(calculator.getResult());
        String profitRate = calculator.calculateProfitRate(customer.getMoney());
        System.out.println(profitRate);
    }
}
