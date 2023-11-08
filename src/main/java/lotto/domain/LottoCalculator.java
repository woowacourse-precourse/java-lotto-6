package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoCalculator {
    private HashMap<Rank, Integer> lottoMap = new HashMap<>();

    public HashMap<Rank, Integer> crateResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        List<Integer> winningList = winningLotto.getWinningNumber().getNumbers();
        lottoMap = init();
        for (Lotto lotto : lottoTicket.getLottoList()) {
            int matchCount = matchingCount(lotto.getNumbers(), winningList);
            boolean isBonus = isContainBonusNumber(lotto.getNumbers(), winningLotto.getBonusNumber());
            Rank rank = Rank.getRankEnum(matchCount, isBonus);
            lottoMap.put(rank, lottoMap.get(rank) + 1);
        }
        lottoMap.remove(Rank.NONE);

        return lottoMap;
    }

    private boolean isContainBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int matchingCount(List<Integer> lottoNumbers, List<Integer> winningList) {
        return (int) lottoNumbers.stream()
                .filter(winningList::contains)
                .count();
    }

    private HashMap<Rank, Integer> init() {
        HashMap<Rank, Integer> init = new HashMap<>();
        for (Rank rank : Rank.values()) {
            init.put(rank, 0);
        }
        return init;
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : lottoMap.keySet()) {
            totalPrize += (long) rank.getWinningPrice() * lottoMap.get(rank);
        }
        return totalPrize;
    }
}
