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

        buyLottos(customer, lottoStore);
        sellLottos(customer, lottoStore);
        WinningNumbersGenerator winningNumbersGenerator = generateWinningNumber();
        generateBonusNumber(winningNumbersGenerator);
        result(customer, winningNumbersGenerator);
    }

    public void buyLottos(final Customer customer, final LottoStore lottoStore) {
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
        long lottoAmounts = lottoStore.getLottoAmount();

        outputView.lottoAmount(lottoAmounts);
        List<Lotto> lottos = customer.getLottos();
        outputView.showLottos(lottos);
    }

    public WinningNumbersGenerator generateWinningNumber() {
        final WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        while (true) {
            try {
                String winningNumberInput = inputView.requestWinningNumber();

                String[] winningNumber = inputView.validateWinningNumberInput(winningNumberInput);
                winningNumbersGenerator.generateWinningNumbers(winningNumber);
                return winningNumbersGenerator;
            } catch (IllegalArgumentException e) {
                outputView.exceptionMessage(e);
            }
        }
    }

    public void generateBonusNumber(final WinningNumbersGenerator winningNumbersGenerator) {
        while (true) {
            try {
                String bonusNumberInput = inputView.requestBonusNumber();

                int bonusNumber = inputView.validateBonusNumberInput(bonusNumberInput);
                winningNumbersGenerator.generateBonusNumber(bonusNumber);
                break ;
            } catch (IllegalArgumentException e) {
                outputView.exceptionMessage(e);
            }
        }
    }

    public void result(final Customer customer, final WinningNumbersGenerator winningNumbersGenerator) {
        final LottoChecker lottoChecker= new LottoChecker(
                winningNumbersGenerator.getWinningNumbers(),
                winningNumbersGenerator.getBonusNumber()
        );

        customer.checkWinningNumber(lottoChecker);
        Map<Prize, Integer> result = lottoChecker.getResult();
        String profitRate = lottoChecker.getProfitRate();

        outputView.prizeResult(result);
        outputView.profitRate(profitRate);
    }
}
