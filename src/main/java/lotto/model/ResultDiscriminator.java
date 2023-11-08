package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDiscriminator {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public ResultDiscriminator(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public Map<Integer, Integer> checkPrize() {
        Map<Integer, Integer> resultCountMap = makeMap();
        for (Lotto lotto : lottos) {
            int matchingNumbers = countMatchingNumbers(lotto, winningLotto);
            boolean matchingBonus = isMatchingBonusNumber(lotto, winningLotto.getBonus().getBonusNumber());
            int resultLotto = result(matchingNumbers, matchingBonus);
            resultCountMap.put(resultLotto, resultCountMap.getOrDefault(resultLotto, 0) + 1);
        }
        return resultCountMap;
    }

    public int checkTotalPrize(Map<Integer, Integer> resultMap) {
        Map<Integer, Integer> prizeValues = new HashMap<>();
        prizeValues.put(1, 2000000000);
        prizeValues.put(2, 30000000);
        prizeValues.put(3, 1500000);
        prizeValues.put(4, 50000);
        prizeValues.put(5, 5000);

        int totalPrize = 0;
        for (int key : prizeValues.keySet()) {
            totalPrize += resultMap.getOrDefault(key, 0) * prizeValues.get(key);
        }

        return totalPrize;
    }

    private int countMatchingNumbers(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();

        int matchingNumbers = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }

    private boolean isMatchingBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        for (int number : numbers) {
            if (bonusNumber == number) {
                return true;
            }
        }
        return false;
    }

    private int result(int matchingCount, boolean matchingBonus) {
        if (matchingCount == 6) {
            return 1;
        }
        if (matchingCount == 5 && matchingBonus) {
            return 2;
        }
        if (matchingCount == 5) {
            return 3;
        }
        if (matchingCount == 4) {
            return 4;
        }
        if (matchingCount == 3) {
            return 5;
        }
        return 0;
    }

    private Map<Integer, Integer> makeMap() {
        Map<Integer, Integer> resultCountMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            resultCountMap.put(i, 0);
        }
        return resultCountMap;
    }
}
