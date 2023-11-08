package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.MoneyManagement;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final InputValidator inputValidator;

    public LottoController(final InputView inputView,
                           final OutputView outputView,
                           final InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void start() {
        MoneyManagement amount = initAmount();
        showAmount(amount);
        Lottos buyLottos = getBuyLottos(amount);

        WinningLotto winningLotto = initWinningLotto();
        LottoResult lottoResult = getResult(buyLottos, winningLotto);

        printResult(amount, lottoResult);
    }

    public MoneyManagement initAmount() {
        try {
            outputView.askAmount();
            String purchaseAmount = inputView.read();
            return MoneyManagement.from(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return initAmount();
        }
    }

    public void showAmount(final MoneyManagement amount) {
        int quantity = amount.getQuantity();
        outputView.showTickets(quantity);
    }

    public Lottos getBuyLottos(final MoneyManagement amount) {
        Lottos buyLottos = buyLotto(amount);
        outputView.showLottoList(buyLottos);
        return buyLottos;
    }

    public Lottos buyLotto(final MoneyManagement amount) {
        int quantity = amount.getQuantity();
        return Lottos.from(quantity);
    }

    public WinningLotto initWinningLotto() {
        Lotto lotto = askWinningNumbers();
        while (true) {
            try {
                Number bonusNumber = askWinningBonusNumber();
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    public Lotto askWinningNumbers() {
        try {
            outputView.askWinningNum();
            String inputWinningNumber = inputView.read();
            return createWinningNumberList(inputWinningNumber);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return askWinningNumbers();
        }
    }

    public Lotto createWinningNumberList(final String inputList) {
        List<String> stringList = inputValidator.toStringList(inputList);
        inputValidator.validateDigit(stringList);
        List<Integer> integerList = inputValidator.toIntegerList(stringList);
        return new Lotto(integerList);
    }

    public Number askWinningBonusNumber() {
        try {
            outputView.askBonusNum();
            String inputBonusNumber = inputView.read();
            return createWinningBonusNumber(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return askWinningBonusNumber();
        }
    }

    public Number createWinningBonusNumber(final String userInput) {
        int userNumber = inputValidator.toInt(userInput);
        return Number.from(userNumber);
    }

    public LottoResult getResult(final Lottos buyLottos,
                                 final WinningLotto winningLotto) {
        return LottoResult.determineWinnings(buyLottos, winningLotto);
    }

    public void printResult(final MoneyManagement amount, final LottoResult lottoResult) {
        printCurrent(lottoResult);
        printYield(amount, lottoResult);
    }

    public void printCurrent(final LottoResult lottoResult) {
        String description = lottoResult.description();
        outputView.showResults(description);
    }

    public void printYield(final MoneyManagement amount, final LottoResult lottoResult) {
        double yield = getYield(amount, lottoResult);
        outputView.showYield(yield);
    }

    public double getYield(final MoneyManagement amount, final LottoResult lottoResult) {
        long profits = getTotal(lottoResult);
        int balance = amount.getBalance();
        return MoneyManagement.calculateYield(balance, profits);
    }

    public long getTotal(final LottoResult lottoResult) {
        return MoneyManagement.totalAmount(lottoResult);
    }
}
