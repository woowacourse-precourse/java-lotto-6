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
                outputView.requestMoney();

                long money = inputView.validateCustomerMoneyInput(Console.readLine());
                customer.insertMoney(lottoStore, money);
                break ;
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
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
                outputView.requestWinningNumber();

                String[] winningNumber = inputView.validateWinningNumberInput(Console.readLine());
                winningNumbersGenerator.generateWinningNumbers(winningNumber);
                break ;
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
            }
        }
    }

    public void generateBonusNumber() {
        while (true) {
            try {
                outputView.requestBonusNumber();

                int bonusNumber = inputView.validateBonusNumberInput(Console.readLine());
                winningNumbersGenerator.generateBonusNumber(bonusNumber);
                break ;
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
            }
        }
    }

    public void result() {
        LottoChecker lottoChecker= new LottoChecker(
                winningNumbersGenerator.getWinningNumbers(),
                winningNumbersGenerator.getBonusNumber()
        );

        customer.checkWinningNumber(lottoChecker);
        lottoChecker.saveLottosResult();
        lottoChecker.calculateTotalPrize();
        lottoChecker.calculateProfitRate();

        Map<Prize, Integer> result = lottoChecker.getResult();
        String profitRate = lottoChecker.getProfitRate();

        outputView.prizeResult(result);
        outputView.profitRate(profitRate);
    }
}
