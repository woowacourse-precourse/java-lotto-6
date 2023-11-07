package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    public static final int RANK_NONE = -1;
    public static final int RANK_FIRST = 0;
    public static final int RANK_SECOND = 1;
    public static final int RANK_THIRD = 2;
    public static final int RANK_FOURTH = 3;
    public static final int RANK_FIFTH = 4;

    List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Map<Integer, Integer> printLottoResult(List<Integer> winnerNumbers, int bonusNumber) {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        lottoResult.put(RANK_FIRST, 0);
        lottoResult.put(RANK_SECOND, 0);
        lottoResult.put(RANK_THIRD, 0);
        lottoResult.put(RANK_FOURTH, 0);
        lottoResult.put(RANK_FIFTH, 0);

        for (Lotto lotto: lottos) {
            List<Integer> lottoNumbers = lotto.getNumber();
            int sameNumberCount = printSameNumberCount(lottoNumbers, winnerNumbers);
            int rank = getRank(sameNumberCount);

            if (rank == -1) {
                continue;
            }
            if (rank == RANK_THIRD && isMatchBonusNumber(lottoNumbers, bonusNumber)) {
                rank = RANK_SECOND;
            }
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        System.out.println(lottoResult);
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

    private int getRank(int sameNumberCount) {
        if (sameNumberCount == 6) {
            return RANK_FIRST;
        }
        if (sameNumberCount == 5) {
            return RANK_THIRD;
        }
        if (sameNumberCount == 4) {
            return RANK_FOURTH;
        }
        if (sameNumberCount == 3) {
            return RANK_FIFTH;
        }
        return RANK_NONE;
    }

    private boolean isMatchBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return (lottoNumbers.contains(bonusNumber));
    }
}