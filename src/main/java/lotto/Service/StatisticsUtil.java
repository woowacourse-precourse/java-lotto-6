package lotto.Service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static lotto.domain.StatisticsUtilEnum.*;

public class StatisticsUtil {

    public List<Integer> getMatchCount(List<Lotto> lottos, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int duplicatedCount = getDuplicatedCount(winningNum, bonusNum, lotto);
            matchCount.add(duplicatedCount);
        }
        return matchCount;
    }

    private int getDuplicatedCount(List<Integer> winningNum, Integer bonusNum, Lotto lotto) {
        int duplicatedCount = (int) lotto.getNumbers().stream().filter(old -> winningNum.stream()
                .anyMatch(Predicate.isEqual(old))).count();
        if (duplicatedCount == CHECK_2ND.getStatus()) {
            duplicatedCount = check2ndPlace(bonusNum, lotto, duplicatedCount);
        }
        return duplicatedCount;
    }

    private int check2ndPlace(Integer bonusNum, Lotto lotto, int duplicatedCount) {
        if (lotto.getNumbers().contains(bonusNum)) {
            duplicatedCount += SECOND_PLACE_TO_LAST_PLACE.getStatus();
        }
        return duplicatedCount;
    }

    public List<Integer> matchCountFrequency(List<Integer> matchCount) {
        List<Integer> matchFrequency = new ArrayList<>();
        for (int i = 0; i < MATCH_SIZE.getStatus(); i++) {
            matchFrequency.add(Collections.frequency(matchCount, i));
        }
        Collections.swap(matchFrequency, CHANGE_LEFT.getStatus(), CHANGE_RIGHT.getStatus());
        return matchFrequency;
    }


    public Integer getTotalReward(List<Integer> matchFrequency, List<String> reward) {
        int totalReward = 0;
        for (int i = 0; i < MATCH_SIZE.getStatus(); i++) {
            totalReward += matchFrequency.get(i) * Integer.parseInt(reward.get(i).replaceAll(",", ""));
        }
        return totalReward;
    }

    public float getReturnRate(List<Integer> matchFrequency, float totalReward) {
        return totalReward / (matchFrequency.stream().mapToInt(Integer::intValue).sum() * LOTTO_PRICE.getStatus()) * 100;
    }
}
