package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    public static Map<Prize, Integer> judgePrize(Lottos lottos, WinningLotto winningLotto) {
        Map<Prize, Integer> result = initializeMap();

        for (int i = 0; i < lottos.getLottos().size(); i++) {
            Lotto lotto = lottos.getLottos().get(i);
            List<Integer> numbers = lotto.getNumbers();

            int count = countMatch(numbers, winningLotto.getWinningNumbers());
            boolean isBonusMatch = isBonusMatch(numbers, winningLotto.getBonusNumber());

            Prize curPrize = Prize.findPrize(count, isBonusMatch);

            if (curPrize != null) {
                int curCount = result.get(curPrize);
                result.put(curPrize, curCount + 1);
            }
        }
        return result;
    }

    private static Map<Prize, Integer> initializeMap() {
        Map<Prize, Integer> result = new HashMap<>();
        List<Prize> prizes = Arrays.asList(Prize.values());
        prizes.forEach(prize -> {
            result.put(prize, 0);
        });
        return result;
    }

    private static int countMatch(List<Integer> numbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isBonusMatch(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
