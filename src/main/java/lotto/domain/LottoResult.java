package lotto.domain;

import static lotto.globar.LottoResultInfo.*;

import java.util.List;
import lotto.globar.LottoResultInfo;

public class LottoResult {

    LottoResultInfo lottoResultInfo;
    private LottoResult() {
    }

    public LottoResult(LottoResultInfo lottoResultInfo) {
        this.lottoResultInfo = lottoResultInfo;
    }

    public static LottoResult createLottoResult(Lotto lotto, LottoWinningCombination lottoWinningCombination) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winnerNums = lottoWinningCombination.getWinnerNums();
        int bonusNum = lottoWinningCombination.getBonusNum();

        return determineLottoResult(lottoNumbers, winnerNums, bonusNum);
    }

    private static LottoResult determineLottoResult(List<Integer> lottoNumbers, List<Integer> winnerNums, int bonusNum) {
        int matchingNumbersCount = countMatchingLottoWithWinnerNums(lottoNumbers, winnerNums);

        if (matchingNumbersCount == 6) {
            return new LottoResult(SIX_MATCH);
        }
        if (matchingNumbersCount == 5 && bonusNumMatched(lottoNumbers, bonusNum)) {
            return new LottoResult(FIVE_MATCH_WITH_BONUS);
        }
        if (matchingNumbersCount == 5) {
            return new LottoResult(FIVE_MATCH);
        }
        if (matchingNumbersCount == 4) {
            return new LottoResult(FOUR_MATCH);
        }
        if (matchingNumbersCount == 3) {
            return new LottoResult(THREE_MATCH);
        }
        return null;
    }


    public static boolean bonusNumMatched(List<Integer> lottoNumbers, int bonusNum) {
        return lottoNumbers.contains(bonusNum);
    }

    public static int countMatchingLottoWithWinnerNums(List<Integer> lottoNumbers, List<Integer> winnerNums) {
        return (int) lottoNumbers
                .stream()
                .filter(winnerNums::contains)
                .count();
    }

    public LottoResultInfo getLottoResultInfo() {
        return lottoResultInfo;
    }
}
