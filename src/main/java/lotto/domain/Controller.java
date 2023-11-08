package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.MatchingCounts;
import lotto.model.Purchase;
import lotto.model.WinningNumbers;
import lotto.validator.Validator;
import lotto.view.View;

public class Controller {
    private final View view;
    private final Validator validator;
    private final GeneratorLotto generatorLotto;
    private final MatchingCounts matchingCounts;
    private final Calculator calculator;

    public Controller(View view, Validator validator, GeneratorLotto generatorLotto, MatchingCounts matchingCounts,
                      Calculator calculator) {
        this.view = view;
        this.validator = validator;
        this.generatorLotto = generatorLotto;
        this.matchingCounts = matchingCounts;
        this.calculator = calculator;
    }

    public void lottoLogic() {
        int purchaseCount = processPurchaseAmount();
        System.out.println();
        view.displayPurchaseQuantityMessage(purchaseCount);

        List<List<Integer>> lottoNumbers = generateLottoNumbersForPurchase(purchaseCount);
        view.displayLottoNumbers(lottoNumbers);

        List<Integer> winningNumbers = processAndValidateWinningNumbers();
        processAndValidateBonusNumber();

        calculateAndDisplayWinningResults(lottoNumbers, winningNumbers);
        view.displayProfitPercent(calculator, matchingCounts);
    }

    private int processPurchaseAmount() {
        System.out.println(PromptMessage.PURCHASE_AMOUNT.getMessage());
        processInputAndValidateData("PurchaseAmount", validator);
        return Purchase.getPurchaseCount();
    }

    private List<Integer> processAndValidateWinningNumbers() {
        System.out.println();
        System.out.println(PromptMessage.WINNING_NUMBERS.getMessage());
        processInputAndValidateData("WinningNumbers", validator);
        return WinningNumbers.getWinningNumbers();
    }

    private void processAndValidateBonusNumber() {
        System.out.println();
        System.out.println(PromptMessage.BONUS_NUMBER.getMessage());
        processInputAndValidateData("BonusNumber", validator);
    }

    private List<List<Integer>> generateLottoNumbersForPurchase(int purchaseAmount) {

        List<Lotto> generatedLotto = GeneratorLotto.generateLottoTickets(purchaseAmount);
        return generatorLotto.generateLottoNumbersList(generatedLotto);
    }

    private void calculateAndDisplayWinningResults(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers) {
        calculateWinningResults(lottoNumbers, winningNumbers);
        view.displayWinningStatistics();
        view.printMatchingCounts(matchingCounts);
    }

    private void calculateWinningResults(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers) {
        calculator.calculateWinningLottoResults(lottoNumbers, winningNumbers);
    }

    public void processInputAndValidateData(String dataType, Validator validator) {
        String input = view.input();
        boolean processed = processAndValidateData(input, dataType, validator);

        while (!processed) {
            view.processErrorResult();
            input = view.input();
            processed = processAndValidateData(input, dataType, validator);
        }
    }

    private boolean processAndValidateData(String input, String dataType, Validator validator) {
        if (dataType.equals("PurchaseAmount")) {
            return processPurchaseAmountData(input, validator);
        }

        if (dataType.equals("WinningNumbers")) {
            return processWinningNumbersData(input, validator);
        }

        if (dataType.equals("BonusNumber")) {
            return processBonusNumberData(input, validator);
        }

        return false;
    }

    public boolean processPurchaseAmountData(String input, Validator validator) {
        return processData(input, validator, Purchase.class);
    }

    public boolean processWinningNumbersData(String input, Validator validator) {
        return processData(input, validator, WinningNumbers.class);
    }

    public boolean processBonusNumberData(String input, Validator validator) {
        return processData(input, validator, BonusNumber.class);
    }

    private boolean processData(String input, Validator validator, Class<?> dataClass) {
        try {
            validator.validateInput(input);
            createDataObject(input, dataClass);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void createDataObject(String input, Class<?> dataClass) {
        if (dataClass == WinningNumbers.class) {
            new WinningNumbers(convertStringToIntegerList(input));
        }

        if (dataClass == Purchase.class) {
            new Purchase(Integer.parseInt(input));
        }

        if (dataClass == BonusNumber.class) {
            new BonusNumber(Integer.parseInt(input));
        }
    }

    public List<Integer> convertStringToIntegerList(String input) {
        String[] inputArray = input.split(",");
        List<Integer> inputWinningNumbers = new ArrayList<>();
        for (String numStr : inputArray) {
            int num = Integer.parseInt(numStr);
            inputWinningNumbers.add(num);
        }
        return inputWinningNumbers;
    }
}