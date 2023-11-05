package lotto.domain.Service;

import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Model.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningService {
    public Map<String, Integer> calculateWinnings(LottoContainer lottoContainer,
                                                  List<Integer> winningNumbers,
                                                  int bonusNumber) {
        Map<String, Integer> winnings = new HashMap<>();

        List<Lotto> lottos = lottoContainer.getLottos();
        for (Lotto lotto : lottos) {
            String rank = judgeWinnings(lotto, winningNumbers, bonusNumber);
            if (rank != null) {
                winnings.put(rank, winnings.getOrDefault(rank, 0) + 1);
            }
        }

        return winnings;
    }

    private String judgeWinnings(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = countMatch(numbers, winningNumbers);
        boolean isBonusMatch = numbers.contains(bonusNumber);

        Prize prize = Prize.prizeCount(matchCount, isBonusMatch);
        if (prize != null) {
            return prize.getRank();
        }
        return null;
    }

    private int countMatch(List<Integer> numbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
