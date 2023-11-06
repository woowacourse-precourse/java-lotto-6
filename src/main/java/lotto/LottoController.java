package lotto;

import static lotto.constant.LottoInformation.LOTTO_PRICE;
import static lotto.constant.message.ErrorMessage.HAS_REMAINDER;
import static lotto.constant.message.InputMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.message.InputMessage.INPUT_MONEY;
import static lotto.constant.message.InputMessage.INPUT_WINNING_NUMBER;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoSeller;
import lotto.domain.WinningNumbers;
import lotto.util.Converter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Converter converter = new Converter();

    public LottoController() {

    }

    public void run() {
        int money = getPurchase();
        Customer customer = purchaseLotto(money);
        Lotto winningNumbers = getWinningLotto();
        WinningNumbers winningLotto = generateWinningLotto(winningNumbers);
        LottoCalculator calculator = new LottoCalculator(customer.checkWinningResult(winningLotto));
        printPrizeResult(calculator);

    }

    private int getPurchase() {
        while (true) {
            try {
                String stringMoney = inputView.requestInputValue(INPUT_MONEY);
                int money = converter.convertInteger(stringMoney);
                validatePurchaseAmount(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int money) {
        if (money % LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException(HAS_REMAINDER.getMessage());
        }
    }

    private Customer purchaseLotto(int money) {
        Customer customer = new Customer(money);
        LottoSeller seller = new LottoSeller(customer.getMoney());
        customer.setLotteryTicket(seller.makeLottoTickets());
        outputView.printLottoNumbers(customer.getLotteryTicket());
        return customer;
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                String input = inputView.requestInputValue(INPUT_WINNING_NUMBER);
                List<Integer> winningNumber = converter.convertIntegerList(input);
                return new Lotto(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers generateWinningLotto(Lotto winningLotto) {
        while (true) {
            try {
                String input = inputView.requestInputValue(INPUT_BONUS_NUMBER);
                int bonusNumber = converter.convertInteger(input);
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
