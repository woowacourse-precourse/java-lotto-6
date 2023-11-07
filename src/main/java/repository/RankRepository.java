package repository;

import java.util.HashMap;
import java.util.Map;

public class RankRepository {

    private static final Map<Integer, Integer> rankRepository = new HashMap<Integer, Integer>();
    private static final Integer DEFAULT_VALUE = 0;
    private static final Integer INCREMENT_VALUE = 1;

    public static void increaseNumberOfWins(Integer rank) {
        rankRepository.put(rank, rankRepository.getOrDefault(rank, DEFAULT_VALUE) + INCREMENT_VALUE);
    }

    public static int getWinningStatistics(int rank) {
        return rankRepository.getOrDefault(rank, DEFAULT_VALUE);
    }
}
