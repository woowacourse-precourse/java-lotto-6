package lotto;

import static lotto.constant.message.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.message.InputMessage.INPUT_MONEY;
import static lotto.constant.message.InputMessage.INPUT_WINNING_NUMBER;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoSeller;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }

    public void run() {
        Customer customer = purchaseLotto();
        Lotto winningNumbers = getWinningLotto();
        WinningNumbers winningLotto = generateWinningLotto(winningNumbers);
        LottoCalculator calculator = new LottoCalculator(customer.checkWinningResult(winningLotto));
        printPrizeResult(calculator);
    }

    private Customer purchaseLotto() {
        while (true) {
            try {
                int money = inputView.requestNumberInput(INPUT_MONEY);
                Customer customer = new Customer(money);
                LottoSeller seller = new LottoSeller(customer.getMoney());
                customer.buyLottoTickets(seller);
                outputView.printLottoNumbers(customer.getLotteryTicket());
                return customer;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                return new Lotto(inputView.requestListInput(INPUT_WINNING_NUMBER));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers generateWinningLotto(Lotto winningLotto) {
        while (true) {
            try {
                int bonusNumber = inputView.requestNumberInput(INPUT_BONUS_NUMBER);
                return new WinningNumbers(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPrizeResult(LottoCalculator calculator) {
        outputView.printResultMessage();
        outputView.printPrizeResult(calculator.getResult());
        outputView.printProfitRate(calculator.calculateProfitRate());
    }

}
