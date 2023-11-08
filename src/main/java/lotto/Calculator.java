package lotto;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
        public static void displayResults(List<Application.LottoResult> results, int coin) {
                int[] countOfResults = new int[Application.LottoResult.values().length];
                int totalPrize = 0;
                for (Application.LottoResult result : results) {
                        if (result != Application.LottoResult.NO_PRIZE) {
                                countOfResults[result.ordinal()]++;
                                totalPrize += result.getPrizeAmount();
                        }
                }


                double profitRate = profitRate(totalPrize, coin);
                System.out.println("당첨 통계\n---");

                for (Application.LottoResult result : Application.LottoResult.values()) {
                        if (result != Application.LottoResult.NO_PRIZE) {
                                int countResult = countOfResults[result.ordinal()];
                                System.out.println(result.getDescription() + " - " + countResult + "개");
                        }
                }

                System.out.println("총 수익률은 " + profitRate + "%입니다.");
        }

        public static double profitRate(int totalPrize, int coin) {
                double toDoubleTotalProfit =((double) totalPrize) / (coin * 1000) * 100;

                return toDoubleTotalProfit;
        }


        public static void checkLottoResultsAndDisplay(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
                for (Lotto lotto : lottoList) {
                        Application.LottoResult result = checkLottoResults(lotto.getNumbers(), winningNumbers, bonusNumber);
                        if (result != Application.LottoResult.NO_PRIZE) {
                                System.out.println(result.getDescription() + " - " + (result == Application.LottoResult.NO_PRIZE ? 0 : 1) + "개");
                        }
                }
        }
        public static int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
                int count = 0;
                for (int number : lottoNumbers) {
                        if (winningNumbers.contains(number)) {
                                count++;
                        }
                }
                return count;
        }
        public static Application.LottoResult checkLottoResults(
                List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
                int matchedNumbers = countMatchingNumbers(lottoNumbers, winningNumbers);
                boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

                if (matchedNumbers == 6) {
                        return Application.LottoResult.FIRST_PRIZE;
                }
                if (matchedNumbers == 5) {
                        if (hasBonusNumber) {
                                return Application.LottoResult.SECOND_PRIZE;
                        }
                        return Application.LottoResult.THIRD_PRIZE;
                }
                if (matchedNumbers == 4) {
                        return Application.LottoResult.FOURTH_PRIZE;
                }
                if (matchedNumbers == 3) {
                        return Application.LottoResult.FIFTH_PRIZE;
                }
                return Application.LottoResult.NO_PRIZE;
        }

        public static void printResult(
                List<Lotto> lottoList,List<Integer> winningNumbers,int bonusNumber, int coin) {
                List<Application.LottoResult> results = new ArrayList<>();
                for (Lotto lotto : lottoList) {
                        Application.LottoResult result = checkLottoResults(lotto.getNumbers(), winningNumbers, bonusNumber);
                        results.add(result);
                }
                displayResults(results, coin);
        }
}
