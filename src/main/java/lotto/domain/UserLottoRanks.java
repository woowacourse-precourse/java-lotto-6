package lotto.domain;

import java.util.Map;
import lotto.constant.LotteryRankConstant;
import lotto.domain.constant.NumberConstant;

public class UserLottoRanks {
    private final Map<LotteryRankConstant, Integer> userLottoRanks;

    private UserLottoRanks(Map<LotteryRankConstant, Integer> userLottoRanks) {
        this.userLottoRanks = userLottoRanks;
    }

    public static UserLottoRanks from(final Map<LotteryRankConstant, Integer> userLottoRanks) {
        initializeToZeroIfValueIsNull(userLottoRanks);
        return new UserLottoRanks(userLottoRanks);
    }

    public static void initializeToZeroIfValueIsNull(final Map<LotteryRankConstant, Integer> userLottoRanks) {
        for (LotteryRankConstant lotteryRankConstant : LotteryRankConstant.values()) {
            if (isValueMappedByKeyNull(userLottoRanks, lotteryRankConstant)) {
                userLottoRanks.put(lotteryRankConstant, NumberConstant.ZERO.getNumber());
            }
        }
    }

    public static boolean isValueMappedByKeyNull(final Map<LotteryRankConstant, Integer> userLottoRanks,
                                                 LotteryRankConstant lotteryRankConstant) {
        return userLottoRanks.getOrDefault(lotteryRankConstant, NumberConstant.ZERO.getNumber())
                == NumberConstant.ZERO.getNumber();
    }

    public Map<LotteryRankConstant, Integer> getUserLottoRanks() {
        return this.userLottoRanks;
    }

    public long calculateWinningAmount() {
        long winningAmount = NumberConstant.ZERO.getNumber();
        for (LotteryRankConstant lotteryRankConstant : LotteryRankConstant.values()) {
            winningAmount += calculatePrizeMoney(
                    userLottoRanks.getOrDefault(lotteryRankConstant, NumberConstant.ZERO.getNumber()),
                    lotteryRankConstant.getPrizeMoney());
        }
        return winningAmount;
    }

    private long calculatePrizeMoney(final int numberOfWinning, final long prizeMoney) {
        return numberOfWinning * prizeMoney;
    }
}