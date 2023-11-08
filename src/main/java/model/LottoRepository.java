package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    public enum Rank {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE
    }

    List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Map<Rank, Integer> printLottoResult(List<Integer> winnerNumbers, int bonusNumber) {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        for (Rank rank: Rank.values()) {
            lottoResult.put(rank, 0);
        }

        for (Lotto lotto: lottos) {
            List<Integer> lottoNumbers = lotto.getNumber();
            int sameNumberCount = printSameNumberCount(lottoNumbers, winnerNumbers);
            Rank rank = getRank(sameNumberCount);

            if (rank == Rank.NONE) {
                continue;
            }
            if (rank == Rank.THIRD && isMatchBonusNumber(lottoNumbers, bonusNumber)) {
                rank = Rank.SECOND;
            }
            lottoResult.put(rank, lottoResult.get(rank) + 1);
        }
        return lottoResult;
    }

    private int printSameNumberCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int sameNumberCount = 0;
        for (int lottoNumber: lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    private Rank getRank(int sameNumberCount) {
        if (sameNumberCount == 6) {
            return Rank.FIRST;
        }
        if (sameNumberCount == 5) {
            return Rank.THIRD;
        }
        if (sameNumberCount == 4) {
            return Rank.FOURTH;
        }
        if (sameNumberCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    private boolean isMatchBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
