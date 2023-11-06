package lotto.domain;

import java.util.List;

public class Judge {

    public int countMatchingNumbers(List<Lotto> lottoList, List<Integer> winNumbers) {
        int count = 0;
        for (Lotto lotto : lottoList) {
            count += countMatchingNumbersInLotto(lotto, winNumbers);
        }
        return count;
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

    public boolean matchesBonusNumber(List<Lotto> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
