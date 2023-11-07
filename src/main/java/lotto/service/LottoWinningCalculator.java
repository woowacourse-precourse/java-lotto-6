package lotto.service;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.Comment;

public class LottoWinningCalculator {
    public static void calculatorLotto(List<Lotto> lottoNumbers, Lotto winningNumbers, int bonusNumber, int purchaseAmount) {
        int countFifthPrize = 0;
        int countFourthPrize = 0;
        int countThirdPrize = 0;
        int countSecondPrize = 0;
        int countFirstPrize = 0;

        for (int index = 0; index < purchaseAmount; index++) {
            int matchingNumbers = calculateMatchingNumbers(lottoNumbers.get(index), winningNumbers);
            boolean hasBonus = lottoNumbers.get(index).getNumbers().contains(bonusNumber);

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

        DecimalFormat format = new DecimalFormat("0.0");
        double profitRate = ((calculateTotalPrize(countFifthPrize, countFourthPrize, countThirdPrize, countSecondPrize, countFirstPrize) - purchaseAmount) / purchaseAmount) * 100;

        System.out.println(Comment.OUTPUT_FIFTH_PRIZE.getComment() + countFifthPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_FOURTH_PRIZE.getComment() + countFourthPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_THIRD_PRIZE.getComment() + countThirdPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_SECOND_PRIZE.getComment() + countSecondPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_FIRST_PRIZE.getComment() + countFirstPrize + Comment.OUTPUT_COUNT.getComment());
        System.out.println(Comment.OUTPUT_TOTAL_RETURN.getComment() + format.format(profitRate) + "%입니다.");
    }

    private static int calculateMatchingNumbers(Lotto lotto, Lotto winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNums = winningNumbers.getNumbers();

        return (int) lottoNumbers.stream()
            .filter(winningNums::contains)
            .count();
    }

    private static double calculateTotalPrize(int countFifthPrize, int countFourthPrize, int countThirdPrize, int countSecondPrize, int countFirstPrize) {
        return (countFifthPrize * 5000) + (countFourthPrize * 50000) + (countThirdPrize * 1500000) + (countSecondPrize * 30000000) + (countFirstPrize * 2000000000);
    }
}
