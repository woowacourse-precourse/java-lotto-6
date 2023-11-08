package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    private static final int FIRST_PRIZE_MATCH_COUNT = 6;
    private static final int SECOND_PRIZE_MATCH_COUNT = 5;
    private static final int SECOND_PRIZE_BONUS_MATCH_COUNT = 1;
    private static final int THIRD_PRIZE_MATCH_COUNT = 5;
    private static final int FOURTH_PRIZE_MATCH_COUNT = 4;
    private static final int FIFTH_PRIZE_MATCH_COUNT = 3;


    private final Map<Rank, Integer> matchCount;
    public WinningChecker(ArrayList<List<Integer>> purchaseLottoNumbers, List<Integer> winningLottoNumber, int bonusNumber) {
        this.matchCount = new HashMap<>();
        initializeMatchCount();
        checkWinningRank(purchaseLottoNumbers, winningLottoNumber, bonusNumber);
    }

    public Map<Rank, Integer> getMatchCount() {
        return matchCount;
    }

    private void initializeMatchCount() {
        for (Rank rank : Rank.values()) {
            matchCount.put(rank, 0);
        }
    }

    private void checkWinningRank(ArrayList<List<Integer>> purchaseLottoNumbers, List<Integer> winningLottoNumber, int bonusNumber) {
        for(List<Integer> purchaseLottoNumber : purchaseLottoNumbers) {
            checkMatchingNumbers(purchaseLottoNumber, winningLottoNumber, bonusNumber);
        }
    }

    private void checkMatchingNumbers(List<Integer> purchaseLottoNumber, List<Integer> winningLottoNumber, int bonusNumber) {
        int matchCount = 0;
        int bonusMatchCount = 0;
        for (int lottoNumber : purchaseLottoNumber) {
            if (winningLottoNumber.contains(lottoNumber)){
                matchCount++;
            }
        }
        if (purchaseLottoNumber.contains(bonusNumber)) {
            bonusMatchCount++;
        }
        checkRank(matchCount, bonusMatchCount);
    }

    private void checkRank(int matchCount, int bonusMatchCount) {
        if (matchCount == FIRST_PRIZE_MATCH_COUNT) {
            increaseMatchCount(Rank.FIRST);
        } else if (matchCount == SECOND_PRIZE_MATCH_COUNT && bonusMatchCount == SECOND_PRIZE_BONUS_MATCH_COUNT) {
            increaseMatchCount(Rank.SECOND);
        } else if (matchCount == THIRD_PRIZE_MATCH_COUNT && bonusMatchCount != SECOND_PRIZE_BONUS_MATCH_COUNT) {
            increaseMatchCount(Rank.THIRD);
        } else if (matchCount == FOURTH_PRIZE_MATCH_COUNT) {
            increaseMatchCount(Rank.FOURTH);
        } else if (matchCount == FIFTH_PRIZE_MATCH_COUNT) {
            increaseMatchCount(Rank.FIFTH);
        }
    }

    private void increaseMatchCount(Rank rank) {
        matchCount.replace(rank, matchCount.get(rank) + 1);
    }
}