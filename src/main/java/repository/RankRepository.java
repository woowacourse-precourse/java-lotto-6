package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Rank;
import lotto.Winnings;

public class RankRepository {

    private static final Map<Integer, Long> rankRepository = new HashMap<Integer, Long>();
    private static final Long DEFAULT_VALUE = 0L;
    private static final Integer INCREMENT_VALUE = 1;
    private static final Integer START_INDEX = 0;
    private static final Integer END_INDEX = 5;
    private static final Integer MIN_RANK = 5;
    private static final Integer ONE_HUNDRED_PERCENT = 100;

    public static void increaseNumberOfWins(Integer rank) {
        if (rank > MIN_RANK) {
            return;
        }
        rankRepository.put(rank, rankRepository.getOrDefault(rank, DEFAULT_VALUE) + INCREMENT_VALUE);
    }

    public static Long getWinningStatistics(int rank) {
        return rankRepository.getOrDefault(rank, DEFAULT_VALUE);
    }

    public static Float getRateOfReturn(int investmentCost) {
        List<Integer> rankList = makeWinnerList();
        List<Long> winningsList = makeWinningsList();
        Long sum = 0L;
        for (int listIndex = START_INDEX;listIndex < END_INDEX;listIndex++) {
            Long winningCount = getWinningStatistics(rankList.get(listIndex));
            Long winnings = winningsList.get(listIndex);
            sum += winningCount * winnings;
        }
        Float rateOfReturn = sum / (float) investmentCost * ONE_HUNDRED_PERCENT;
        return rateOfReturn;
    }

    private static List<Long> makeWinningsList() {
        return List.of(Winnings.FIRST_PLACE_PRIZE.getPrize(),
                Winnings.SECOND_PLACE_PRIZE.getPrize(),
                Winnings.THIRD_PLACE_PRIZE.getPrize(),
                Winnings.FOURTH_PLACE_PRIZE.getPrize(),
                Winnings.FIFTH_PLACE_PRIZE.getPrize());
    }

    private static List<Integer> makeWinnerList() {
        return List.of(Rank.FIRST_PLACE.getRank(),
            Rank.SECOND_PLACE.getRank(),
            Rank.THIRD_PLACE.getRank(),
            Rank.FOURTH_PLACE.getRank(),
            Rank.FIFTH_PLACE.getRank());
    }
}
