package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    private static final int FIRST_PRIZE_AMOUNT = 2000000000;
    private static final int SECOND_PRIZE_AMOUNT = 30000000;
    private static final int THIRD_PRIZE_AMOUNT = 1500000;
    private static final int FOURTH_PRIZE_AMOUNT = 50000;
    private static final int FIFTH_PRIZE_AMOUNT = 5000;
    private static int finalPrize;
    private static List<Integer> finalMatchNumbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

    public static int calculatePrize(List<Integer> userLottoNumbers, List<Integer> winningLottoNumber, int bonusNumber) {
        int matchedNumbers = countMatchedNumbers(userLottoNumbers, winningLottoNumber);
        boolean hasBonusNumber = userLottoNumbers.contains(bonusNumber);

        if (matchedNumbers == 6) {
            finalPrize += FIRST_PRIZE_AMOUNT;
            finalMatchNumbers.set(0, finalMatchNumbers.get(0) + 1);
            return finalPrize;
        }
        if (matchedNumbers == 5 && hasBonusNumber) {
            finalPrize += SECOND_PRIZE_AMOUNT;
            finalMatchNumbers.set(1, finalMatchNumbers.get(1) + 1);
            return finalPrize;
        }
        if (matchedNumbers == 5) {
            finalPrize += THIRD_PRIZE_AMOUNT;
            finalMatchNumbers.set(2, finalMatchNumbers.get(2) + 1);
            return finalPrize;
        }
        if (matchedNumbers == 4) {
            finalPrize += FOURTH_PRIZE_AMOUNT;
            finalMatchNumbers.set(3, finalMatchNumbers.get(3) + 1);
            return finalPrize;
        }
        if (matchedNumbers == 3) {
            finalPrize += FIFTH_PRIZE_AMOUNT;
            finalMatchNumbers.set(4, finalMatchNumbers.get(4) + 1);
            return finalPrize;
        }
        return 0;
    }

    private static int countMatchedNumbers(List<Integer> userLottoNumbers, List<Integer> winningLottoNumber) {
        return (int) userLottoNumbers.stream().filter(winningLottoNumber::contains).count();
    }

    public static List<Integer> getFinalMatchNumbers() {
        return finalMatchNumbers;
    }

    public static void initialize() {
        finalPrize = 0;
        finalMatchNumbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
    }
}