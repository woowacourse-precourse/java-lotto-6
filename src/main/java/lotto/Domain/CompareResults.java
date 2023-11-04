package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompareResults {

    public static void compareLottoResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {

        for (Lotto lotto : purchasedLottos) {
            int matchingCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);
        }
    }

    private static int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
