package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.dto.BuyingResults;
import lotto.dto.WinningResults;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.generator.WinningResultMessageGenerator;
import lotto.resolver.ExceptionResolver;
import lotto.validator.input.InputCommonValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGame(final InputView inputView, final OutputView outputView, final LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void startGame() {
        ExceptionResolver.resolveProcess(LottoGame::buyLottos, this);
        printBuyingResults();
        ExceptionResolver.resolveProcess(LottoGame::inputWinningLotto, this);
        printWinningResult();
    }

    private void buyLottos() {
        int price = inputBuyingPrice();
        lottoMachine.buyLottos(RandomLottoNumberGenerator.getSupplier(), price);
    }

    private int inputBuyingPrice() {
        String inputPrice = inputView.inputBuyingPrice();
        InputCommonValidator.validateSingle(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    private void inputWinningLotto() {
        List<Integer> winningNumbers = ExceptionResolver.resolveInput(this::inputLottoNumbers);
        int bonusNumber = ExceptionResolver.resolveInput(this::inputBonusNumber);
        lottoMachine.addWinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> inputLottoNumbers() {
        List<String> inputNumbers = inputView.inputLottoNumbers();
        InputCommonValidator.validateMultiple(inputNumbers);
        return convertToNumbers(inputNumbers);
    }

    private int inputBonusNumber() {
        String inputNumber = inputView.inputBonusNumber();
        InputCommonValidator.validateSingle(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private void printWinningResult() {
        WinningResults winningResults = lottoMachine.createWinningResults();
        String message = WinningResultMessageGenerator.generate(winningResults);
        outputView.printWinningResult(message);
    }

    private List<Integer> convertToNumbers(final List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void printBuyingResults() {
        BuyingResults buyingResults = lottoMachine.createBuyingResults();
        outputView.printBuyingResults(buyingResults.getBuyingCount(), buyingResults.createResultMessage());
    }
}
