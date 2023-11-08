package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.validator.InputValidator;

public class Program {
    private LottoTerminal lottoTerminal = new LottoTerminal();
    private Customer customer = new Customer(lottoTerminal);
    private InputValidator inputValidator = new InputValidator();

    private long purchaseAmount;
    private String[] winningNumbers;
    private String bonusNumber;
    private List<List<Integer>> allLottoIssued = new ArrayList<>();
    private int[] countMatching;
    private boolean[] bonusMatching;
    HashMap<String, Integer> statistics = new HashMap<>();

    public void start() {
        processPayment();
        allLottoIssued = lottoTerminal.LottoIssuance();
        lottoTerminal.printAllLotto();

        processWinningNumber();
        processBonusNumber();
        calculateWinnings();
        calculateStatistics();
    }

    private void processPayment() {
        boolean isValidAmount = false;

        while (!isValidAmount) {
            String inputAmount = lottoTerminal.requestAndReadPurchaseAmount();

            isValidAmount = handlePurchaseAmount(inputAmount);
        }
        customer.expendForLotto(purchaseAmount);
    }

    private boolean handlePurchaseAmount(String inputAmount) {
        try {
            validatePurchaseAmount(inputAmount);
            purchaseAmount = Long.parseLong(inputAmount);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    private void validatePurchaseAmount(String value) {
        inputValidator.validateNonEmpty(value);
        inputValidator.validateNonZeroAmount(value);
        inputValidator.validateOnlyNumeric(value);
        inputValidator.validateLongValueRange(value);
        inputValidator.validateAmountDivisibility(value);
    }

    private void processWinningNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println();
            String winningNumber = lottoTerminal.requestAndReadWinningNumber();

            isValidInput = handleWinningNumber(winningNumber);
        }
    }

    private boolean handleWinningNumber(String value) {
        try {
            validateWinningNumber(value);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    private void validateWinningNumber(String value) {
        inputValidator.validateNonEmpty(value);
        winningNumbers = inputValidator.validateSeparatedByComma(value);
        inputValidator.validateOnlyNumericValues(winningNumbers);
        for (int i = 0; i < winningNumbers.length; i++) {
            inputValidator.validateNumbersInRange(winningNumbers[i]);
        }

        inputValidator.validateNoDuplicates(winningNumbers);
    }

    private void processBonusNumber() {
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println();
            bonusNumber = lottoTerminal.requestAndReadBonusNumber();

            isValidInput = handleBonusNumber(bonusNumber);
        }
    }

    private boolean handleBonusNumber(String value) {
        try {
            validateBonusNumber(value);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    private void validateBonusNumber(String value) {
        inputValidator.validateNonEmpty(value);
        inputValidator.validateNumericOnly(value);
        inputValidator.validateNumbersInRange(value);
    }

    private void calculateWinnings() {
        countMatching = new int[allLottoIssued.size()];
        bonusMatching = new boolean[allLottoIssued.size()];

        for (int i = 0; i < allLottoIssued.size(); i++) {
            for (int k = 0; k < winningNumbers.length; k++) {
                calculateWinningCount(i, k);
            }
            checkBonus(i);
        }
    }

    private void calculateWinningCount(int lottoIdx, int winningNumberIdx) {
        if (allLottoIssued.get(lottoIdx).contains(Integer.parseInt(winningNumbers[winningNumberIdx]))) {
            countMatching[lottoIdx]++;
        }
    }

    private void checkBonus(int lottoIdx) {
        if (allLottoIssued.get(lottoIdx).contains(Integer.parseInt(bonusNumber))) {
            bonusMatching[lottoIdx] = true;
        }
    }

    public void calculateStatistics() {
        setDataStructureForStatistics();

        for (int i = 0; i < countMatching.length; i++) {
            checkThreeMatching(i);
            checkFourMatching(i);
            checkFiveMatching(i);
            checkSixMatching(i);
        }
    }

    private void setDataStructureForStatistics() {
        statistics.put("3", 0);
        statistics.put("4", 0);
        statistics.put("5", 0);
        statistics.put("5+bonus", 0);
        statistics.put("6", 0);
    }

    private void checkThreeMatching(int idx) {
        if (countMatching[idx] == 3) {
            statistics.put("3", statistics.get("3") + 1);
        }
    }

    private void checkFourMatching(int idx) {
        if (countMatching[idx] == 4) {
            statistics.put("4", statistics.get("4") + 1);
        }
    }

    private void checkFiveMatching(int idx) {
        if (countMatching[idx] == 5) {
            if (bonusMatching[idx]) {
                statistics.put("5+bonus", statistics.get("5+bonus") + 1);
            }
            if (!bonusMatching[idx]) {
                statistics.put("5", statistics.get("5") + 1);
            }
        }
    }

    private void checkSixMatching(int idx) {
        if (countMatching[idx] == 6) {
            statistics.put("6", statistics.get("6") + 1);
        }
    }
}
