package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.LottoConstants;
import lotto.StringConstants;
import lotto.domain.Lotto;
import lotto.port.LottoNumbersProvider;

public class LottoService {

    private final LottoNumbersProvider lottoNumbersProvider;

    public LottoService(LottoNumbersProvider lottoNumbersProvider) {
        this.lottoNumbersProvider = lottoNumbersProvider;
    }

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        validateLottoPurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount) / LottoConstants.PRICE.getValue();
    }

    public void validateLottoPurchaseAmount(String lottoPurchaseAmount) {

        if (PurchaseAmountNOTDivideBy1000(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                StringConstants.FIRST_ERROR_MESSAGE + StringConstants.PURCHASE_AMOUNT_DIVIDE_EXCEPTION_MESSAGE);
        }

        if (PurchaseAmountNotDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                StringConstants.FIRST_ERROR_MESSAGE + StringConstants.PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean PurchaseAmountNOTDivideBy1000(String lottoPurchaseAmount) {
        int amount = Integer.parseInt(lottoPurchaseAmount);
        return amount % LottoConstants.PRICE.getValue() != 0;
    }

    private boolean PurchaseAmountNotDigit(String lottoPurchaseAmount) {
        try {
            Integer.parseInt(lottoPurchaseAmount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public List<List<Integer>> generateLottoNumbers(int lottoTicketsCount) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();

        System.out.println(lottoTicketsCount + "개를 구매했습니다.");

        for (int i = 0; i < lottoTicketsCount; i++) {
            List<Integer> lottoNumbers = lottoNumbersProvider.provideLottoNumbers();
            Collections.sort(lottoNumbers);
            allLottoNumbers.add(lottoNumbers);
            System.out.println(lottoNumbers);
        }
        return allLottoNumbers;
    }

    public List<Integer> addLottoNumberToWinningNumbers(String lottoNumbersString) {
        List<Integer> winningNumbers = convertStringToWinningNumbers(lottoNumbersString);
        Lotto lotto = new Lotto(winningNumbers);

        return lotto.getNumbers();
    }


    public List<Integer> convertStringToWinningNumbers(String lottoNumbersString) {
        String[] splitNumbers = lottoNumbersString.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            try {
                lottoNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.WINNING_NUMBERS_NOT_DIGIT_EXCEPTION_MESSAGE);
            }
        }
        return lottoNumbers;
    }

    public void validateBonusNumber(List<Integer> lottoWinningNumbers, String bonusNumber) {
        if (bonusNumberNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
        if (bonusNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        if (bonusNumberDuplicateWinningNumbers(lottoWinningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE + StringConstants.BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public boolean bonusNumberNotDigit(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public boolean bonusNumberWrongRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        return number < LottoConstants.NUMBER_MIN.getValue() || number > LottoConstants.NUMBER_MAX.getValue();
    }

    public boolean bonusNumberDuplicateWinningNumbers(List<Integer> lottoWinningNumbers, String bonusNumber) {
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        return lottoWinningNumbers.contains(bonusNumberInt);
    }

    public Map<Integer, Integer> calculateMatchingCounts(List<List<Integer>> userLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> matchingCounts = new HashMap<>();
        for (List<Integer> lottoNumbers : userLottoNumbers) {
            int count = countMatchedNumbers(lottoNumbers, winningNumbers);
            if (count == 5 && isMatchedBonusNumber(lottoNumbers, bonusNumber)) {
                count = 7;
            }
            matchingCounts.put(count, matchingCounts.getOrDefault(count, 0) + 1);
        }
        return matchingCounts;
    }

    public int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchedBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public void printStatistics(Map<Integer, Integer> matchingCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchingCounts.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchingCounts.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchingCounts.getOrDefault(5, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingCounts.getOrDefault(7, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchingCounts.getOrDefault(6, 0) + "개");
    }

    public void printReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        double returnRate = calculateReturnRate(matchingCounts, lottoTicketsCount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    public double calculateReturnRate(Map<Integer, Integer> matchingCounts, int lottoTicketsCount) {
        int totalPrize = 0;
        totalPrize += matchingCounts.getOrDefault(3, 0) * 5000;
        totalPrize += matchingCounts.getOrDefault(4, 0) * 50000;
        totalPrize += matchingCounts.getOrDefault(5, 0) * 1500000;
        totalPrize += matchingCounts.getOrDefault(7, 0) * 30000000;
        totalPrize += matchingCounts.getOrDefault(6, 0) * 2000000000;
        double purchaseAmount = lottoTicketsCount * LottoConstants.PRICE.getValue();
        return totalPrize / purchaseAmount * 100;
    }
}