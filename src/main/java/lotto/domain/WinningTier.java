package lotto.domain;

import lotto.dto.WinningResponseDto;
import lotto.dto.WinningTierResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningTier {

    private static final int WINNING_TIER_START_INDEX = 0;
    private static final int DEFAULT_VALUE = 0;
    private static final int START_TIER_VALUE = 1;
    private static final int PLUS_UNIT = 1;
    private static final int END_TIER_VALUE = 5;
    private static final int WINNING_TIER_DEFAULT_VALUE = 0;

    private HashMap<Integer, Integer> winningTier;

    public WinningTier() {
        this.winningTier = new HashMap<>();
        initializeWinningTier();
    }

    private void initializeWinningTier() {
        for (int tier = START_TIER_VALUE; tier <= END_TIER_VALUE; tier++) {
            this.winningTier.put(tier, WINNING_TIER_DEFAULT_VALUE);
        }
    }

    public void estimate(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        HashMap<Integer, Integer> tempWinningTier = new HashMap<>();
        for (int i = WINNING_TIER_START_INDEX; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics confirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);
            int rank = confirmResult.getRank();
            if(winningTier.containsKey(rank)) {
                tempWinningTier.put(rank, tempWinningTier.getOrDefault(rank, DEFAULT_VALUE) + PLUS_UNIT);
            }
        }
        tempWinningTier.forEach((rank, count) -> winningTier.merge(rank, count, Integer::sum));
    }


    public WinningTierResponseDto generateWinningResponseMap() {
        Map<Integer, WinningResponseDto> responseMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : winningTier.entrySet()) {
            WinningStatistics winningStatistics = WinningStatistics.getWinningStatisticsByRank(entry.getKey());

            if (winningStatistics.isValidRank()) {
                WinningResponseDto responseDto = WinningResponseDto.create(winningStatistics, entry.getValue());
                responseMap.put(entry.getKey(), responseDto);
            }
        }

        return WinningTierResponseDto.of(responseMap);
    }




    public HashMap<Integer, Integer> toHashMap() {
        return this.winningTier;
    }
}
