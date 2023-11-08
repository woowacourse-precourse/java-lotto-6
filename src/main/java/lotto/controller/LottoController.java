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

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public static LottoResult getResult(Lottos buyLottos, WinningLotto winningLotto) {
        return LottoResult.determineWinnings(buyLottos, winningLotto);
    }

    public void start() {
        MoneyManagement amount = initAmount();
        showAmount(amount);
        Lottos buyLottos = getBuyLottos(amount);

        WinningLotto winningLotto = initWinningLotto();
        LottoResult lottoResult = getResult(buyLottos, winningLotto);

        printResult(amount, lottoResult);
    }

    public Lottos getBuyLottos(MoneyManagement amount) {
        Lottos buyLottos = buyLotto(amount);
        outputView.showLottoList(buyLottos);
        return buyLottos;
    }

    public double getYield(MoneyManagement amount, LottoResult lottoResult) {
        long profits = getTotal(lottoResult);
        int balance = amount.getBalance();
        return MoneyManagement.calculateYield(balance, profits);
    }

    public long getTotal(LottoResult lottoResult) {
        return MoneyManagement.totalAmount(lottoResult);
    }

    public void showAmount(MoneyManagement amount) {
        int quantity = amount.getQuantity();
        outputView.showTickets(quantity);
    }

    public MoneyManagement initAmount() {
        outputView.askAmount();
        String purchaseAmount = inputView.read();
        return MoneyManagement.from(purchaseAmount);
    }

    public Lottos buyLotto(MoneyManagement amount) {
        int quantity = amount.getQuantity();
        return Lottos.from(quantity);
    }

    public Lotto askWinningNumbers() {
        outputView.askWinningNum();
        String inputWinningNumber = inputView.read();
        return createWinningNumberList(inputWinningNumber);
    }

    public Lotto createWinningNumberList(String inputList) {
        List<String> stringList = inputValidator.toStringList(inputList);
        inputValidator.validateDigit(stringList);
        List<Integer> integerList = inputValidator.toIntegerList(stringList);
        return new Lotto(integerList);
    }

    public Number askWinningBonusNumber() {
        outputView.askBonusNum();
        String inputBonusNumber = inputView.read();
        return createWinningBonusNumber(inputBonusNumber);
    }

    public Number createWinningBonusNumber(String userInput) {
        int userNumber = inputValidator.toInt(userInput);
        return Number.from(userNumber);
    }

    public WinningLotto initWinningLotto() {
        Lotto lotto = askWinningNumbers();
        Number number = askWinningBonusNumber();
        return new WinningLotto(lotto, number);
    }

    public void printCurrent(LottoResult lottoResult) {
        String description = lottoResult.description();
        outputView.showResults(description);
    }

    public void printYield(MoneyManagement amount, LottoResult lottoResult) {
        double yield = getYield(amount, lottoResult);
        outputView.showYield(yield);
    }

    public void printResult(MoneyManagement amount, LottoResult lottoResult) {
        printCurrent(lottoResult);
        printYield(amount, lottoResult);
    }
}
