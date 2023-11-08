package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;

import static lotto.model.Rank.*;
import static lotto.model.Rank.LOOSE;

public class RankingService {
    public static void calculateWinnersByRank(Rank rank, int[] rankBoard) {
        switch (rank) {
            case FIRST:
                rankBoard[1] += 1;
                break;
            case SECOND:
                rankBoard[2] += 2;
                break;
            case THIRD:
                rankBoard[3] += 1;
                break;
            case FOURTH:
                rankBoard[4] += 1;
                break;
            case FIFTH:
                rankBoard[5] += 1;
                break;
        }
    }

    public static Rank getRank(List<Integer> userNumbers, int matchCount, int bonusNumber) {
        if (matchCount == 5 && userNumbers.contains(bonusNumber)) {
            return SECOND;
        }

        switch (matchCount) {
            case 6:
                return FIRST;
            case 5:
                return THIRD;
            case 4:
                return FOURTH;
            case 3:
                return FIFTH;
            case 2, 1, 0:
                return LOOSE;
        }

        return LOOSE;
    }
}
