package lotto;

import static lotto.constant.message.Error.BONUS_RANGE;
import static lotto.constant.message.Error.NUMBER_BLANK;
import static lotto.constant.message.Error.NUMBER_COUNT;
import static lotto.constant.message.Error.NUMBER_DUPLICATE;
import static lotto.constant.message.Error.NUMBER_RANGE;
import static lotto.constant.message.Error.PURCHASE_TYPE;
import static lotto.constant.message.Error.PURCHASE_UNIT;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constant.Number;
import view.InputView;
import view.OutputView;

public class Play {
    private final InputView input = new InputView();
    private final OutputView outputView = new OutputView();
    /*public void run () {
        outputView.printPurchase();
        String purchaseInput = getValidPurchase();
        Purchase purchase = new Purchase(purchaseInput);
        outputView.printPurchaseAmount(purchase.getPurchaseAmount());
        outputView.printPurchaseLotto(purchase);

        outputView.printEnterWinning();
        List<Integer> numbers = getValidNumbers();

        outputView.printEnterBonus();
        int bonusNumber = getValidBonusNumber();

        Winning winning = new Winning(numbers, bonusNumber);

        Compare compare = new Compare(winning, purchase);
        compare.calculateStatistics();
        compare.printResult();

        int purchasePrice = Integer.parseInt(purchaseInput);
        String profit = compare.computeEarningRate(purchasePrice);

        outputView.printProfit(Double.parseDouble(profit));
    }

    private List<Integer> getValidNumbers() {
        while (true) {
            try {
                String userInput = input.getInput();
                validateBlank(userInput);
                List<Integer> numbers = parseNumbers(userInput);
                validateNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println((e.getMessage()));
            }
        }
    }*/
    public void run() {
        String purchaseInput = getPurchaseInput();
        Purchase purchase = makePurchase(purchaseInput);

        List<Integer> numbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        Winning winning = new Winning(numbers, bonusNumber);
        showResults(winning, purchase, purchaseInput);
    }

    private String getPurchaseInput() {
        outputView.printPurchase();
        return getValidPurchase();
    }

    private Purchase makePurchase(String purchaseInput) {
        Purchase purchase = new Purchase(purchaseInput);
        outputView.printPurchaseAmount(purchase.getPurchaseAmount());
        outputView.printPurchaseLotto(purchase);
        return purchase;
    }

    private List<Integer> getWinningNumbers() {
        outputView.printEnterWinning();
        return getValidNumbers();
    }

    private int getBonusNumber() {
        outputView.printEnterBonus();
        return getValidBonusNumber();
    }

    private void showResults(Winning winning, Purchase purchase, String purchaseInput) {
        Compare compare = new Compare(winning, purchase);
        compare.calculateStatistics();
        compare.printResult();

        int purchasePrice = Integer.parseInt(purchaseInput);
        String profit = compare.computeEarningRate(purchasePrice);
        outputView.printProfit(Double.parseDouble(profit));
    }
    private String getValidPurchase() {
        while (true) {
            try {
                String userInput = input.getInput();
                validateBlank(userInput);
                validatePurchase(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println((e.getMessage()));
            }
        }
    }

    private List<Integer> getValidNumbers() {
        while (true) {
            try {
                String userInput = input.getInput();
                validateBlank(userInput);
                List<Integer> numbers = parseNumbers(userInput);
                validateNumber(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println((e.getMessage()));
            }
        }
    }

    private int getValidBonusNumber() {
        while (true) {
            try {
                String userInput = input.getInput();
                validateBlank(userInput);
                int bonusNumber = Integer.parseInt(userInput);
                validateBonus(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println((e.getMessage()));
            }
        }
    }

    private void validateNumber(List<Integer> numbers) {
        if (numbers.size() != Number.CNT.getRange()) {
            throw new IllegalArgumentException(NUMBER_COUNT.getMessage());
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < Number.MIN.getRange() || number > Number.MAX.getRange())) {
            throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
        }
    }

    private void validateBonus(int bonus) {
        if (bonus < Number.MIN.getRange() || bonus > Number.MAX.getRange()) {
            throw new IllegalArgumentException(BONUS_RANGE.getMessage());
        }
    }

    private void validatePurchase(String input) {
        try {
            int purchase = Integer.parseInt(input);
            if (purchase % Number.PURCHASE_UNIT.getRange() != 0) {
                throw new IllegalArgumentException(PURCHASE_UNIT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_TYPE.getMessage());
        }
    }

        public List<Integer> parseNumbers (String input){
            validateBlank(input);
            return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        }

        private void validateBlank (String input){
            if (input.contains(" ")) {
                throw new IllegalArgumentException(NUMBER_BLANK.getMessage());
            }
        }
    }

