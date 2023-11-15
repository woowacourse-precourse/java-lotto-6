package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    public static Map<Prize, Integer> judgePrize(Lottos lottos, WinningLotto winningLotto) {
        Map<Prize, Integer> result = initializeMap();
        List<Lotto> lottoList = lottos.getLottoList();

        for (Lotto lotto : lottoList) {
            judgeEachLotto(winningLotto, lotto, result);
        }
        return result;
    }

    private static void judgeEachLotto(WinningLotto winningLotto, Lotto lotto, Map<Prize, Integer> result) {
        List<Integer> numbers = lotto.getNumbers();

        int count = countMatch(numbers, winningLotto.getNumbers());
        boolean isBonusMatch = isBonusMatch(numbers, winningLotto.getBonusNumber());

        Prize prize = Prize.findPrize(count, isBonusMatch);

        if (prize != null) {
            int curCount = result.get(prize);
            result.put(prize, curCount + 1);
        }
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
