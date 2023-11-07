package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final Customer customer = new Customer();
    private final LottoStore lottoStore = new LottoStore();
    private final WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

    public LottoController(final InputView inputView,
                           final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buyLottos() {
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

    public void sellLottos() {
        lottoStore.sellLottos(customer);
        long lottoAmounts = lottoStore.getLottoAmount();

        outputView.lottoAmount(lottoAmounts);
        List<Lotto> lottos = customer.showLottoPapers();
        outputView.showLottos(lottos);
    }

    public void generateWinningNumber() {
        while (true) {
            try {
                String winningNumberInput = inputView.requestWinningNumber();

                String[] winningNumber = inputView.validateWinningNumberInput(winningNumberInput);
                winningNumbersGenerator.generateWinningNumbers(winningNumber);
                break ;
            } catch (IllegalArgumentException e) {
                outputView.exceptionMessage(e);
            }
        }
    }

    public void generateBonusNumber() {
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

    public void result() {
        LottoChecker lottoChecker= new LottoChecker(
                winningNumbersGenerator.getWinningNumbers(),
                winningNumbersGenerator.getBonusNumber()
        );

        customer.checkWinningNumber(lottoChecker);
//        lottoChecker.saveLottosResult();
//        lottoChecker.calculateTotalPrize();
//        lottoChecker.calculateProfitRate();

        Map<Prize, Integer> result = lottoChecker.getResult();
        String profitRate = lottoChecker.getProfitRate();

        outputView.prizeResult(result);
        outputView.profitRate(profitRate);
    }
}
