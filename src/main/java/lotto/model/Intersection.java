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

    public List checkBonusNumber(int bonusNum, List<Set> lottoNum) {
        List<Integer> intersectionBonus = new ArrayList<>();
        for (Set intersectionCheck : lottoNum) {
            if (intersectionCheck.contains(bonusNum)) {
                intersectionBonus.add(1);
            }
            if (!intersectionCheck.contains(bonusNum)) {
                intersectionBonus.add(0);
            }
        }
        return intersectionBonus;
    }
}
