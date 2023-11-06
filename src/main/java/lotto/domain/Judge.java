package lotto.domain;

import java.util.ArrayList;
import java.util.List;


public class Judge {

    public List<LottoResult> countMatchingNumbers(List<Lotto> lottoList, List<Integer> winNumbers) {
        List<LottoResult> results = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            int matchingCount = countMatchingNumbersInLotto(lotto, winNumbers);
            boolean isWinner = isWinner(matchingCount);
            results.add(new LottoResult(isWinner, matchingCount));
        }

        return results;
    }

    private int countMatchingNumbersInLotto(Lotto lotto, List<Integer> winNumbers) {
        int count = 0;
        for (int winNumber : winNumbers) {
            if (lotto.contains(winNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean isWinner(int matchingCount) {
        return matchingCount >= 3;
    }

}
