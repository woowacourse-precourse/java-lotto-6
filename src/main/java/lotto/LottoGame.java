package lotto;

import lotto.domain.LottoMachine;
import lotto.dto.BuyingResults;
import lotto.exception.ExceptionResolver;
import lotto.generator.RandomLottoNumberGenerator;
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
    }

    private void buyLottos() {
        int price = inputBuyingPrice();
        lottoMachine.buyLottos(RandomLottoNumberGenerator.getSupplier(), price);
        printBuyingResults();
    }

    private int inputBuyingPrice() {
        String inputPrice = inputView.inputBuyingPrice();
        InputCommonValidator.validate(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    private void printBuyingResults() {
        BuyingResults buyingResults = lottoMachine.createBuyingResults();
        outputView.printBuyingResults(buyingResults.getCount(), buyingResults.createResultMessage());
    }
}
