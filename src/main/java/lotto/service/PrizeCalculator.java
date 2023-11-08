package lotto.service;

import java.util.*;
import java.util.function.Predicate;
import lotto.domain.*;
import lotto.utils.Pair;

public class PrizeCalculator {

    private final Lottos lottos;

    private final Lotto prizeLotto;

    private final int bonusNumber;

    public PrizeCalculator(Lotto prizeLotto, Lottos lottos, int bonusNumber) {
        this.lottos = lottos;
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Map.Entry<Integer, Boolean>> caculatePrize() {
        Iterator iterator = lottos.createIterator();
        List<Map.Entry<Integer, Boolean>> results = new ArrayList<>();
        while (iterator.hasNext()) {
            Lotto lotto = (Lotto) iterator.next();
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNumbers);
            boolean isContainBonus = lotto.getNumbers().contains(bonusNumber);
            results.add(Pair.of(matchCount, isContainBonus));
        }
        return results;
    }



    private int getMatchCount(List<Integer> lottoNumbers) {
        List<Integer> result = lottoNumbers.stream()
                .filter(lottoNumber -> prizeLotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(lottoNumber)))
                .toList();
        int matchCount = result.size();
        return matchCount;
    }
}
