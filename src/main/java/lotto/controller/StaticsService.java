package lotto.controller;

import lotto.model.Constant;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StaticsService {
    public static List<Integer> getWinningStatics(HashMap<Lotto, Rank> lottos) {
        List<Integer> ranking = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (Rank rank : lottos.values()) {
            countWinning(ranking, rank);
        }

        return ranking;
    }

    private static void countWinning(List<Integer> ranking, Rank rank) {
        if (rank == Rank.FIRST) ranking.set(4, ranking.get(4) + 1);
        else if (rank == Rank.SECOND) ranking.set(3, ranking.get(3) + 1);
        else if (rank == Rank.THIRD) ranking.set(2, ranking.get(2) + 1);
        else if (rank == Rank.FOURTH) ranking.set(1, ranking.get(1) + 1);
        else if (rank == Rank.FIFTH) ranking.set(0, ranking.get(0) + 1);
    }

    public static double calculateReturnRate(List<Integer> ranking, int input) {
        int output = 0;
        for (int i = 0; i < ranking.size(); i++) {
            output += ranking.get(i) * Constant.REWARD[i];
        }

        return (double) output / input * 100;
    }
}
