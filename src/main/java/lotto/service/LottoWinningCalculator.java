package lotto.service;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.Comment;
import lotto.utils.constants.LottoNumConstant;

public class LottoWinningCalculator {

    static int countFifthPrize = 0;
    static int countFourthPrize = 0;
    static int countThirdPrize = 0;
    static int countSecondPrize = 0;
    static int countFirstPrize = 0;
    static DecimalFormat format = new DecimalFormat("0.0");

    public static void calculatorLotto(List<Lotto> lottoNumbers, Lotto winningNumbers, int bonusNumber,
        int purchaseAmount) {
        for (int index = 0; index < purchaseAmount; index++) {
            updatePrizeCounts(lottoNumbers.get(index), winningNumbers, bonusNumber);
        }

        double profitRate = calculateProfitRate(countFifthPrize, countFourthPrize, countThirdPrize, countSecondPrize,
            countFirstPrize, purchaseAmount);

        printPrizeCounts(profitRate);
    }

    private static void updatePrizeCounts(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        int matchingNumbers = calculateMatchingNumbers(lotto, winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        if (matchingNumbers == LottoNumConstant.LOTTO_THREE_COUNT.getNumber()) {
            countFifthPrize++;
        } else if (matchingNumbers == LottoNumConstant.LOTTO_FOUR_COUNT.getNumber()) {
            countFourthPrize++;
        } else if (matchingNumbers == LottoNumConstant.LOTTO_FIVE_COUNT.getNumber() && hasBonus) {
            countSecondPrize++;
        } else if (matchingNumbers == LottoNumConstant.LOTTO_FIVE_COUNT.getNumber()) {
            countThirdPrize++;
        } else if (matchingNumbers == LottoNumConstant.LOTTO_SIX_COUNT.getNumber()) {
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

    private static double calculateTotalPrize(int countFifthPrize, int countFourthPrize, int countThirdPrize,
        int countSecondPrize, int countFirstPrize) {
        int fifthPrize = countFifthPrize * LottoNumConstant.LOTTO_FIFTH_PRIZE.getNumber();
        int fourthPrize = countFourthPrize * LottoNumConstant.LOTTO_FOURTH_PRIZE.getNumber();
        int thirdPrize = countThirdPrize * LottoNumConstant.LOTTO_THIRD_PRIZE.getNumber();
        int secondPrize = countSecondPrize * LottoNumConstant.LOTTO_SECOND_PRIZE.getNumber();
        int firstPrize = countFirstPrize * LottoNumConstant.LOTTO_FIRST_PRIZE.getNumber();

        return fifthPrize + fourthPrize + thirdPrize + secondPrize + firstPrize;
    }

    private static double calculateProfitRate(int countFifthPrize, int countFourthPrize, int countThirdPrize,
        int countSecondPrize, int countFirstPrize, int purchaseAmount) {
        double totalPrize = calculateTotalPrize(countFifthPrize, countFourthPrize, countThirdPrize, countSecondPrize,
            countFirstPrize);
        double profitRate = totalPrize / purchaseAmount;
        return Math.round(profitRate * 10.0) / 100.0;
    }

    private static void printPrizeCounts(double profitRate) {
        System.out.println(
            Comment.OUTPUT_FIFTH_PRIZE.getComment() + countFifthPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(
            Comment.OUTPUT_FOURTH_PRIZE.getComment() + countFourthPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(
            Comment.OUTPUT_THIRD_PRIZE.getComment() + countThirdPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(
            Comment.OUTPUT_SECOND_PRIZE.getComment() + countSecondPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(
            Comment.OUTPUT_FIRST_PRIZE.getComment() + countFirstPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_TOTAL_RETURN.getComment() + format.format(profitRate) + "%입니다.");
    }
}
