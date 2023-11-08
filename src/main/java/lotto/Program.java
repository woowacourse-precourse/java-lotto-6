package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.validator.InputValidator;

public class Program {
    private static final String matchesCount1stPlace = "6";
    private static final String matchesCount2ndPlace = "5+bonus";
    private static final String matchesCount3rdPlace = "5";
    private static final String matchesCount4thPlace = "4";
    private static final String matchesCount5thPlace = "3";
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
            check1stPlaceMatching(i);
            check2ndAnd3rdPlaceMatching(i);
            check4thPlaceMatching(i);
            check5thPlaceMatching(i);
        }
    }

    private void setDataStructureForStatistics() {
        statistics.put(matchesCount5thPlace, 0);
        statistics.put(matchesCount4thPlace, 0);
        statistics.put(matchesCount3rdPlace, 0);
        statistics.put(matchesCount2ndPlace, 0);
        statistics.put(matchesCount1stPlace, 0);
    }

    private void check5thPlaceMatching(int idx) {
        if (countMatching[idx] == Integer.parseInt(matchesCount5thPlace)) {
            statistics.put(matchesCount5thPlace, statistics.get(matchesCount5thPlace) + 1);
        }
    }

    private void check4thPlaceMatching(int idx) {
        if (countMatching[idx] == Integer.parseInt(matchesCount4thPlace)) {
            statistics.put(matchesCount4thPlace, statistics.get(matchesCount4thPlace) + 1);
        }
    }

    private void check2ndAnd3rdPlaceMatching(int idx) {
        if (countMatching[idx] == Integer.parseInt(matchesCount3rdPlace)) {
            if (bonusMatching[idx]) {
                statistics.put(matchesCount2ndPlace, statistics.get(matchesCount2ndPlace) + 1);
            }
            if (!bonusMatching[idx]) {
                statistics.put(matchesCount3rdPlace, statistics.get(matchesCount3rdPlace) + 1);
            }
        }
    }

    private void check1stPlaceMatching(int idx) {
        if (countMatching[idx] == Integer.parseInt(matchesCount1stPlace)) {
            statistics.put(matchesCount1stPlace, statistics.get(matchesCount1stPlace) + 1);
        }
    }
}
