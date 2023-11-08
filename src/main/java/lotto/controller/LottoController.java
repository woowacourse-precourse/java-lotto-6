package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView,
                           final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Customer customer = new Customer();
        final LottoStore lottoStore = new LottoStore();

        purchaseLottos(customer, lottoStore);
        sellLottos(customer, lottoStore);

        final WinningNumbers winningNumbers = generateWinningNumber();
        generateBonusNumber(winningNumbers);
        final LottoChecker lottoChecker = result(customer, winningNumbers);

        outputView.prizeResult(lottoChecker.getResult());
        outputView.profitRate(lottoChecker.getProfitRate());
    }

    public void purchaseLottos(final Customer customer, final LottoStore lottoStore) {
        while (true) {
            try {
                String moneyInput = inputView.requestLottoMoneyToBuy();

                long money = inputView.validateCustomerMoneyInput(moneyInput);
                customer.insertMoney(lottoStore, money);
                break;
            } catch (IllegalArgumentException e) {
                outputView.exceptionMessage(e);
            }
        }
    }

    public void sellLottos(final Customer customer, final LottoStore lottoStore) {
        lottoStore.sellLottos(customer);

        final List<Lotto> lottos = customer.getLottos();
        outputView.lottoAmount(lottos.size());

        outputView.showLottos(lottos);
    }

    public WinningNumbers generateWinningNumber() {
        final WinningNumbers winningNumbers = new WinningNumbers();

        while (true) {
            try {
                final String winningNumberInput = inputView.requestWinningNumber();

                final List<Integer> winningNumber = inputView.validateWinningNumberInput(winningNumberInput);
                winningNumbers.generateWinningNumbers(winningNumber);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.exceptionMessage(e);
            }
        }
    }

    public void generateBonusNumber(final WinningNumbers winningNumbers) {
        while (true) {
            try {
                final String bonusNumberInput = inputView.requestBonusNumber();

                final int bonusNumber = inputView.validateBonusNumberInput(bonusNumberInput);
                winningNumbers.generateBonusNumber(bonusNumber);
                break ;
            } catch (IllegalArgumentException e) {
                outputView.exceptionMessage(e);
            }
        }
    }

    public LottoChecker result(final Customer customer, final WinningNumbers winningNumbers) {
        final LottoChecker lottoChecker= new LottoChecker(
                winningNumbers.getWinningNumbers(),
                winningNumbers.getBonusNumber()
        );

        customer.checkResult(lottoChecker);
        return lottoChecker;
    }
}
