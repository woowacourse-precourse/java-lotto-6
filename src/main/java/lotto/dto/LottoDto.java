package lotto.dto;

import static lotto.constants.LottoConstants.BONUS_COUNT_ONE;
import static lotto.constants.LottoConstants.BONUS_RANDOMLY_ZERO;
import static lotto.constants.LottoConstants.LOTTO_MATCH_COUNT_ADD_BONUS;
import static lotto.constants.LottoConstants.LOTTO_RANDOMLY_SEVEN;
import static lotto.constants.LottoConstants.MATCHES_COUNT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public record LottoDto(List<Integer> lottoRandomNumbers, Lotto lotto) {

    public Map<Integer, Integer> matchCount(List<Integer> lottoWinnerNumbers,
            int bonus) {
        Map<Integer, Integer> lottoMatchCount = generateWinnerCount(lottoWinnerNumbers, bonus);
        return lottoMatchCount;
    }

    private Map<Integer, Integer> generateWinnerCount(List<Integer> lottoWinnerNumbers, int bonusNumber) {
        int matchLottoCount = 0;
        int bonusCount = 0;
        Map<Integer, Integer> matchesCount = new HashMap<>();
        for (int i = 0; i < lottoRandomNumbers.size(); i++) {
            matchLottoCount += lottoWinnerNumbersContainCount(lottoWinnerNumbers, lottoRandomNumbers.get(i));
        }
        bonusCount += bonusContainsCount(matchLottoCount, bonusNumber);
        if (matchLottoCount == MATCHES_COUNT && bonusCount == BONUS_COUNT_ONE) {
            bonusCount = BONUS_RANDOMLY_ZERO;
            matchLottoCount = LOTTO_RANDOMLY_SEVEN;
        }
        matchesCount.put(matchLottoCount, bonusCount);
        return matchesCount;
    }

    private int lottoWinnerNumbersContainCount(List<Integer> lottoWinnerNumbers, int lottoRandomNumber) {
        int count = 0;
        if (lottoWinnerNumbers.contains(lottoRandomNumber)) {
            count++;
        }
        return count;
    }

    private int bonusContainsCount(int checkMatcherCountFive, int bonus) {
        int count = 0;
        if (checkMatcherCountFive == LOTTO_MATCH_COUNT_ADD_BONUS && lottoRandomNumbers.contains(bonus)) {
            count++;
        }
        return count;
    }
}