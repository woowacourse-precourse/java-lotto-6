package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoMachine;
import lotto.dto.BuyingResults;
import lotto.dto.WinningResults;
import lotto.exception.ExceptionResolver;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.generator.WinningResultMessageGenerator;
import lotto.validator.InputCommonValidator;
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
        ExceptionResolver.resolveProcess(this::buyLottos);
        inputWinningNumbers();
        printWinningResult();
    }

    private void buyLottos() {
        int price = inputBuyingPrice();
        lottoMachine.buyLottos(RandomLottoNumberGenerator.getSupplier(), price);
        printBuyingResults();
    }

    private int inputBuyingPrice() {
        String inputPrice = inputView.inputBuyingPrice();
        InputCommonValidator.validateSingle(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    private void inputWinningNumbers() {
        ExceptionResolver.resolveProcess(this::inputLottoNumbers);
        ExceptionResolver.resolveProcess(this::inputBonusNumber);
    }

    private void inputLottoNumbers() {
        List<String> inputNumbers = inputView.inputLottoNumbers();
        InputCommonValidator.validateMultiple(inputNumbers);
        List<Integer> lottoNumbers = convertToNumbers(inputNumbers);
        lottoMachine.addLottoNumbers(lottoNumbers);
    }

    private void inputBonusNumber() {
        String inputNumber = inputView.inputBonusNumber();
        InputCommonValidator.validateSingle(inputNumber);
        lottoMachine.addBonusNumber(Integer.parseInt(inputNumber));
    }

    private void printWinningResult() {
        WinningResults winningResult = lottoMachine.createWinningResult();
        String message = WinningResultMessageGenerator.generate(winningResult);
        outputView.printWinningResult(message);
    }

    private List<Integer> convertToNumbers(final List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void printBuyingResults() {
        BuyingResults buyingResults = lottoMachine.createBuyingResults();
        outputView.printBuyingResults(buyingResults.getCount(), buyingResults.createResultMessage());
    }
}
