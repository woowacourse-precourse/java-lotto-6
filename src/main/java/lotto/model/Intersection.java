package lotto.model;

import java.util.*;

public class Intersection {

    public List<Integer> countMatchingNumbers(List<Integer> winningNumbers, List<Set> userLottoNumbers) {
        List<Integer> matchingCounts = new ArrayList<>();
        for (Set<Integer> userNumbers : userLottoNumbers) {
            Set<Integer> intersection = new HashSet<>(userNumbers);
            intersection.retainAll(winningNumbers);
            matchingCounts.add(intersection.size());
        }
        return matchingCounts;
    }

    public List checkBonusNumber(String bonusNum, List<Set> lottoNum) {
        List<Boolean> intersectionBonus = new ArrayList<>();
        for (Set intersectionCheck : lottoNum) {
            if (intersectionCheck.contains(Integer.parseInt(bonusNum))) {
                intersectionBonus.add(true);
            }
            if (!intersectionCheck.contains(Integer.parseInt(bonusNum))) {
                intersectionBonus.add(false);
            }
        }
        return intersectionBonus;
    }
}
