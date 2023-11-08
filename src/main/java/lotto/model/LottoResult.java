package lotto.model;

import static lotto.util.Constant.CHECK_BONUS_NUMBER;
import static lotto.util.Constant.SECOND_GET_MATCH_COUNT;

import java.util.List;

public class LottoResult {

    public static int matchResult(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int match = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }

    public static int checkBonusNumber(List<Integer> lottoNumbers, int match, int bonusNumber) {
        if (match == SECOND_GET_MATCH_COUNT && lottoNumbers.contains(bonusNumber)) {
            return match * CHECK_BONUS_NUMBER;
        }
        return match;
    }

    public static void addCount(int match) {
        for (LottoRanking ranking : LottoRanking.values()) {
            if (match == ranking.getMatchCount()) {
                LottoRanking.addCount(ranking);
            }
        }
    }

}
