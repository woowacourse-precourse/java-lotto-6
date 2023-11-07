package lotto.model;

import static lotto.model.LottoRanking.SECOND;

import java.util.List;

public class LottoResult {

    private int matchResult(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int match = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }

    private int checkBonusNumber(List<Integer> lottoNumbers, int match, int bonusNumber) {
        if (match == SECOND.getMatchCount() && lottoNumbers.contains(bonusNumber)) {
            return match * 7;
        }
        return match;
    }


}
