package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.util.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public static final String COMMA = ",";
    private final OutputView outputView;
    private final InputView inputView;

    public LottoGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        purchaseLotto();
        Lotto winningNumbers = setWinningNumbers();
    }

    private Lotto setWinningNumbers() {
        try {
            outputView.printInputWinningNumbers();
            String inputWinningNumbers = inputView.inputWinningNumbers();
            WinningNumbersValidator.validate(inputWinningNumbers);
            List<Integer> numbers = convertStringToList(inputWinningNumbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return setWinningNumbers();
    }

    private List<Integer> convertStringToList(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void purchaseLotto() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        Lottos lottos = createLottos(purchaseAmount.getNumberOfLotto());
        outputView.printLottos(lottos);
    }

    private Lottos createLottos(int numberOfLotto) {
        return new Lottos(numberOfLotto);
    }

    public PurchaseAmount setPurchaseAmount() {
        try {
            outputView.printInputPurchaseAmount();
            String amount = inputView.inputPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return setPurchaseAmount();
    }
}
