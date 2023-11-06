package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class PlayService {

    public static void playLotto() {

        int purchaseAmount = validatePurchaseAmount();
        List<Lotto> resultsOfLottoIssuance = validateResultsOfLottoIssuance(purchaseAmount);
        Lotto lotto = validateLotto();
        int bonusNumber = validateBonusNumber(lotto);

        printStringForResults();
        HashMap<Integer, Integer> results
                = ResultService.saveWinningResults(resultsOfLottoIssuance, lotto, bonusNumber);
        printResults(results);

        BigDecimal rateOfReturn = ResultService.calculateRateOfReturn(purchaseAmount, results);
        printRateOrReturn(rateOfReturn);
    }

    private static int validateBonusNumber(Lotto lotto) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = InputService.getUserInputForBonusNumber(lotto);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private static Lotto validateLotto() {
        Lotto lotto;
        while (true) {
            try {
                lotto = InputService.getUserInputForLottoNumbers();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private static List<Lotto> validateResultsOfLottoIssuance(int purchaseAmount) {
        int numberOfLottoTickets;
        List<Lotto> resultsOfLottoIssuance;
        while (true) {
            try {
                numberOfLottoTickets = ResultService.calculateNumberOfLottoTickets(purchaseAmount);
                printNumberOfLottoTickets(numberOfLottoTickets);
                resultsOfLottoIssuance = ResultService.getResultsOfLottoIssuance(numberOfLottoTickets);
                printResultsOfLottoIssuance(resultsOfLottoIssuance);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultsOfLottoIssuance;
    }

    private static int validatePurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = InputService.getUserInputForPurchaseAmount();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public static void printNumberOfLottoTickets(int purchaseNumber) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseNumber);
    }

    public static void printResultsOfLottoIssuance(List<Lotto> resultsOfLottoIssuance) {
        for (Lotto result : resultsOfLottoIssuance) {
            printSortResult(result);
        }
    }

    private static void printSortResult(Lotto result) {
        List<Integer> sortedResult = result.sortNumbers(result);
        System.out.println(sortedResult);
    }

    public static void printStringForResults() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResults(HashMap<Integer, Integer> results) {
        for (int caseNumber : results.keySet()) {
            System.out.printf(WinnigCase.getByCaseNumber(caseNumber).getContents()
                    + " - %d개\n", results.get(caseNumber));
        }
    }

    public static void printRateOrReturn(BigDecimal rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn.setScale(1, RoundingMode.HALF_UP) + "%입니다.");
    }
}
