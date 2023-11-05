package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final Set<Integer> winningsNumbers;
    private final int bonusNumber;

    public LottoMatcher(List<Integer> winningsNumbers, int bonusNumber) {
        this.winningsNumbers = new HashSet<>(winningsNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<LottoResult, Integer> match(List<Lotto> lottos) {
        Map<LottoResult, Integer> counter = Arrays
                .stream(LottoResult.values())
                .collect(Collectors.toMap(l1 -> l1, l2 -> 0));

        Map<LottoResult, Integer> lottoResults = new HashMap<>(counter);

        for (Lotto lotto : lottos) {
            LottoResult result = matchLotto(lotto);
            lottoResults.put(result, lottoResults.getOrDefault(result, 0) + 1);
        }

        return lottoResults;
    }

    private LottoResult matchLotto(Lotto lotto) {
        int winningCount = 0;
        boolean existBonusNumber = false;

        for (int num : lotto.getNumbers()) {
            if (winningsNumbers.contains(num)) winningCount++;
            if (num == bonusNumber) existBonusNumber = true;
        }

        return LottoResult.of(winningCount, existBonusNumber);
    }
}
