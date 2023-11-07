package lotto.service;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.Comment;

public class LottoWinningCalculator {
    static int countFifthPrize = 0;
    static int countFourthPrize = 0;
    static int countThirdPrize = 0;
    static int countSecondPrize = 0;
    static int countFirstPrize = 0;
    static DecimalFormat format = new DecimalFormat("0.0");

    public static void calculatorLotto(List<Lotto> lottoNumbers, Lotto winningNumbers, int bonusNumber, int purchaseAmount) {
        for (int index = 0; index < purchaseAmount; index++) {
            updatePrizeCounts(lottoNumbers.get(index), winningNumbers, bonusNumber);
        }

        double profitRate = calculateProfitRate(countFifthPrize, countFourthPrize, countThirdPrize, countSecondPrize, countFirstPrize, purchaseAmount);

        printPrizeCounts(profitRate);
    }

    private static void updatePrizeCounts(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        int matchingNumbers = calculateMatchingNumbers(lotto, winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        if (matchingNumbers == 3) {
            countFifthPrize++;
        } else if (matchingNumbers == 4) {
            countFourthPrize++;
        } else if (matchingNumbers == 5 && hasBonus) {
            countSecondPrize++;
        } else if (matchingNumbers == 5) {
            countThirdPrize++;
        } else if (matchingNumbers == 6) {
            countFirstPrize++;
        }
    }

    private static int calculateMatchingNumbers(Lotto lotto, Lotto winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNums = winningNumbers.getNumbers();

        return (int) lottoNumbers.stream()
            .filter(winningNums::contains)
            .count();
    }

    private static double calculateTotalPrize(int countFifthPrize, int countFourthPrize, int countThirdPrize, int countSecondPrize, int countFirstPrize) {
        int fifthPrize = countFifthPrize * 5000;
        int fourthPrize = countFourthPrize * 50000;
        int thirdPrize = countThirdPrize * 1500000;
        int secondPrize = countSecondPrize * 30000000;
        int firstPrize = countFirstPrize * 2000000000;

        return fifthPrize + fourthPrize + thirdPrize + secondPrize + firstPrize;
    }

    private static double calculateProfitRate(int countFifthPrize, int countFourthPrize, int countThirdPrize, int countSecondPrize, int countFirstPrize, int purchaseAmount) {
        double totalPrize = calculateTotalPrize(countFifthPrize, countFourthPrize, countThirdPrize, countSecondPrize, countFirstPrize);
        double profitRate = totalPrize / purchaseAmount;
        return Math.round(profitRate * 10.0) / 100.0;
    }

    private static void printPrizeCounts(double profitRate) {
        System.out.println(Comment.OUTPUT_FIFTH_PRIZE.getComment() + countFifthPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_FOURTH_PRIZE.getComment() + countFourthPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_THIRD_PRIZE.getComment() + countThirdPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_SECOND_PRIZE.getComment() + countSecondPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_FIRST_PRIZE.getComment() + countFirstPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_TOTAL_RETURN.getComment() + format.format(profitRate) + "%입니다.");
    }
}
