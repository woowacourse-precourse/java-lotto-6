package lotto.domain;

import java.util.List;

public class Judge {
    private static final LottoResult OUT_OF_RANK = null;

    private Judge() {
    }

    public static int compareWinningNumbers(Lotto winnings, Lotto randoms) {
        int matchCount = 0;
        List<Integer> winningNumbers = winnings.getNumbers();
        List<Integer> randomNumbers = randoms.getNumbers();

        for (Integer number : winningNumbers) {
            if (randomNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean compareBonusNumber(Lotto givenInput, LottoBonus Bonus) {
        List<Integer> givenNumbers = givenInput.getNumbers();
        int bonusNumber = Bonus.getNumber();
        if (givenNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public static LottoResult findRank(Lotto randomNumbers, Lotto winningNumbers, LottoBonus bonus) {
        int matchCount = compareWinningNumbers(winningNumbers, randomNumbers);
        boolean isMatchBonusNumber = compareBonusNumber(randomNumbers, bonus);
        return LottoResult.getLottoResult(matchCount, isMatchBonusNumber);
    }

    public static LottoRankCount calculateRank(List<Lotto> randoms, Lotto winnings, LottoBonus bonus) {
        LottoRankCount lottoRankCount = new LottoRankCount();
        for (Lotto randomNumbers : randoms) {
            LottoResult lottoResult = findRank(randomNumbers, winnings, bonus);
            if (lottoResult != OUT_OF_RANK) {
                int currentRank = lottoResult.getRank();
                lottoRankCount.incrementCount(currentRank);
            }
        }
        return lottoRankCount;
    }

    public static int calculateEarnings(List<Lotto> randoms, Lotto winnings, LottoBonus bonus) {
        int totalEarnings = 0;
        for (Lotto randomNumbers : randoms) {
            LottoResult lottoResult = Judge.findRank(randomNumbers, winnings, bonus);
            if (lottoResult != OUT_OF_RANK) {
                totalEarnings += lottoResult.getLottoWinningAmount();
            }
        }
        return totalEarnings;
    }

}
