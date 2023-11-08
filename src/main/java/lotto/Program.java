package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.validator.InputValidator;

public class Program {
    private static final int MIN_OF_LOTTO_NUMBER = 1;
    private static final int MAX_OF_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private static final String matchesCount1stPlace = "6";
    private static final String matchesCount2ndPlace = "5+bonus";
    private static final String matchesCount3rdPlace = "5";
    private static final String matchesCount4thPlace = "4";
    private static final String matchesCount5thPlace = "3";
    private static final int Lotto5thPlaceReward = 5000;
    private static final int Lotto4thPlaceReward = 50000;
    private static final int Lotto3rdPlaceReward = 1500000;
    private static final int Lotto2ndPlaceReward = 30000000;
    private static final int Lotto1stPlaceReward = 2000000000;
    private LottoTerminal lottoTerminal = new LottoTerminal();
    private InputValidator inputValidator = new InputValidator();

    private long purchaseAmount;
    private long countOfLottoIssued;
    private String[] winningNumbers;
    private String bonusNumber;
    private List<List<Integer>> allLottoIssued = new ArrayList<>();
    private int[] countMatching;
    private boolean[] bonusMatching;
    private HashMap<String, Integer> statistics = new HashMap<>();
    private BigDecimal rateOfReturn;

    public void start() {
        processPayment();
        allLottoIssued = lottoIssuance();
        lottoTerminal.printAllLotto(countOfLottoIssued, allLottoIssued);

        processWinningNumber();
        processBonusNumber();
        calculateWinnings();
        calculateStatistics();
        calculateRateOfReturn();
        lottoTerminal.printWinningStatistics(statistics, rateOfReturn);
    }

    private void processPayment() {
        boolean isValidAmount = false;

        while (!isValidAmount) {
            String inputAmount = lottoTerminal.requestAndReadPurchaseAmount();

            isValidAmount = handlePurchaseAmount(inputAmount);
        }
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

    public List<List<Integer>> lottoIssuance() {
        long amountForCalculate = purchaseAmount;

        while (amountForCalculate > 0) {
            List<Integer> numbersOfLotto = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER,
                            6));

            Lotto lotto = new Lotto(numbersOfLotto);
            allLottoIssued.add(numbersOfLotto);
            countOfLottoIssued++;
            amountForCalculate -= LOTTO_PRICE;
        }
        return allLottoIssued;
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

    public void calculateRateOfReturn() {
        BigInteger sum = calculateSumOfRewards();
        BigDecimal sumTemp = new BigDecimal(sum);

        BigInteger purchaseAmountTemp = BigInteger.valueOf(purchaseAmount);

        BigDecimal rateOfReturnTemp = sumTemp.multiply(new BigDecimal("100"))
                .divide(new BigDecimal(purchaseAmountTemp), 2, RoundingMode.HALF_UP);

        rateOfReturn = rateOfReturnTemp.setScale(1, RoundingMode.HALF_UP);
    }

    private BigInteger calculateSumOfRewards() {
        BigInteger rewardOf5th = BigInteger.valueOf(
                (long) statistics.get(matchesCount5thPlace) * (long) Lotto5thPlaceReward);
        BigInteger rewardOf4th = BigInteger.valueOf(
                (long) statistics.get(matchesCount4thPlace) * (long) Lotto4thPlaceReward);
        BigInteger rewardOf3rd = BigInteger.valueOf(
                (long) statistics.get(matchesCount3rdPlace) * (long) Lotto3rdPlaceReward);
        BigInteger rewardOf2nd = BigInteger.valueOf(
                (long) statistics.get(matchesCount2ndPlace) * (long) Lotto2ndPlaceReward);
        BigInteger rewardOf1st = BigInteger.valueOf(
                (long) statistics.get(matchesCount1stPlace) * (long) Lotto1stPlaceReward);

        return rewardOf1st.add(rewardOf2nd).add(rewardOf3rd).add(rewardOf4th).add(rewardOf5th);
    }
}
