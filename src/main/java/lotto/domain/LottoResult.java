package lotto.domain;

import static lotto.globar.GlobalConstants.*;

import java.util.List;
import lotto.globar.GlobalConstants;

public class LottoResult {
    private String rank;
    private long prize;

    private LottoResult() {
    }

    private LottoResult(String rank, long prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public static LottoResult createLottoResult(Lotto lotto, LottoWinningCombination lottoWinningCombination) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winnerNums = lottoWinningCombination.getWinnerNums();
        int bonusNum = lottoWinningCombination.getBonusNum();

        int matchingNumbersCount = matchLottoWithWinnerNums(lottoNumbers, winnerNums);

        if (matchingNumbersCount == 6) {
            return new LottoResult(FIRST_RANK, FIRST_PRIZE);
        }
        if (matchingNumbersCount == 5 && bonusNumMatched(lottoNumbers, bonusNum)) {
            return new LottoResult(SECOND_RANK, SECOND_PRIZE);
        }
        if (matchingNumbersCount == 5) {
            return new LottoResult(THIRD_RANK, THIRD_PRIZE);
        }
        if (matchingNumbersCount == 4) {
            return new LottoResult(FOURTH_RANK, FOURTH_PRIZE);
        }
        if (matchingNumbersCount == 3) {
            return new LottoResult(FIFTH_RANK, FIFTH_PRIZE);
        }
        return new LottoResult(NO_RANK, NO_PRIZE);
    }

    private static boolean bonusNumMatched(List<Integer> lottoNumbers, int bonusNum) {
        return lottoNumbers.contains(bonusNum);
    }

    private static int matchLottoWithWinnerNums(List<Integer> lottoNumbers, List<Integer> winnerNums) {
        return (int) lottoNumbers
                .stream()
                .filter(winnerNums::contains)
                .count();
    }
}
