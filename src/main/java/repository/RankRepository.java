package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankRepository {

    private static final Map<Integer, Integer> rankRepository = new HashMap<Integer, Integer>();
    private static final Integer DEFAULT_VALUE = 0;
    private static final Integer INCREMENT_VALUE = 1;
    private static final Integer START_INDEX = 0;
    private static final Integer END_INDEX = 5;

    public static void increaseNumberOfWins(Integer rank) {
        rankRepository.put(rank, rankRepository.getOrDefault(rank, DEFAULT_VALUE) + INCREMENT_VALUE);
    }

    public static int getWinningStatistics(int rank) {
        return rankRepository.getOrDefault(rank, DEFAULT_VALUE);
    }

    public static Float getRateOfReturn(int investmentCost) {
        List<Integer> rankList = List.of(1, 2, 3, 4, 5);
        List<Integer> winningsList = List.of(2000000000, 30000000, 1500000, 50000, 5000);
        Long sum = 0L;
        for (int listIndex = START_INDEX;listIndex<END_INDEX;listIndex++) {
            Integer winningCount = getWinningStatistics(rankList.get(listIndex));
            Integer winnings = winningsList.get(listIndex);
            sum += (long) winningCount * winnings;
        }
        return sum / (float) investmentCost * 100;
    }
}
