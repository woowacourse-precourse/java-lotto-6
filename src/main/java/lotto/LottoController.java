package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ValueValidator;
import lotto.model.WinningResult;
import lotto.model.WinningValidator;
import lotto.model.YieldCalculator;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoController {
    private final InputView inputView;
    private final OutPutView outputView;
    private final ValueValidator valueValidator;
    private final LottoGenerator lottoGenerator;
    private final WinningValidator winningValidator;
    private final WinningResult winningResult;
    private final YieldCalculator yieldCalculator;

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> lottos = new ArrayList<>();
    public List<Integer> winningNumbers = new ArrayList<>();
    public int purchasedPrice;
    public int lottoAmount;
    public int bonusNumber;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutPutView();
        this.valueValidator = new ValueValidator();
        this.lottoGenerator = new LottoGenerator();
        this.winningValidator = new WinningValidator();
        this.winningResult = new WinningResult();
        this.yieldCalculator = new YieldCalculator();
    }

    public void inputPurchasedPrice() {
        boolean isValidated = false;
        String inputPurchasedPrice = "";

        while (!isValidated) {
            try {
                inputPurchasedPrice = inputView.promptForPurchasedPrice();
                isValidated = valueValidator.validatePurchasedPrice(inputPurchasedPrice);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        purchasedPrice = Integer.parseInt(inputPurchasedPrice);
    }

    public void generateLottos() {
        lottoAmount = purchasedPrice / LOTTO_PRICE;
        lottos.clear();
        lottos = lottoGenerator.generateLotto(lottoAmount);

        outputView.printPurchasedLottoAmount(lottoAmount);
        outputView.printGeneratedLottos(lottos);
    }

    public void generateWinningCondition() {
        boolean isValidated = false;

        while (!isValidated) {
            try {
                String winningInput = inputView.promptForWinningCondition();
                winningNumbers = lottoGenerator.winningInputToWinningLotto(winningInput);
                isValidated = valueValidator.validateWinningInputValue(winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputBonusNumber() {
        boolean isValidated = false;

        while (!isValidated) {
            try {
                String inputBonusNumber = inputView.promptForBonusNumber();
                isValidated = valueValidator.validateBonusNumber(inputBonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void generateWinningResult() {
        int matchNumber;
        boolean isMatchBonus;

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();

            matchNumber = winningValidator.countMatchNumbers(winningNumbers, numbers);
            isMatchBonus = winningValidator.checkWinningBonusNumber(numbers, bonusNumber);
            winningResult.increaseWinningCount(matchNumber, isMatchBonus);
        }
    }

    public void displayFinalResult() {
        outputView.printOutputStartMessage();

        Map<String, Integer> winningResults = winningResult.displayWinningResults();
        double yeild = yieldCalculator.calculateYieldCalulator(winningResults, purchasedPrice);

        outputView.printWinningCountResult(winningResults);
        outputView.printYield(yeild);
    }
}
