package lotto.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public record LottoDto(List<Integer> lottoRandomNumbers, Lotto lotto) {

    public Map<Integer, Integer> matchCount(List<Integer> lottoWinnerNumbers,
            int bonus) {
        int count = lotto.matchLottoCount(lottoWinnerNumbers);
        int bonusCount = isContainsCount(bonus);
        Map<Integer, Integer> countPair = new HashMap<>();
        countPair.put(count, bonusCount);
        return countPair;
    }

    public int isContainsCount(int bonus) {
        int count = 0;
        boolean isContains = lotto.isBonusMatch(bonus);
        if (isContains) {
            count++;
        }
        return count;
    }
}