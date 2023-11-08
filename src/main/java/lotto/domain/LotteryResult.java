package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LotteryRankConstant;
import lotto.domain.constant.RankDifferenceConstant;

public class LotteryResult {
    private final WinningLottoNumbers winningLottoNumbers;
    private final BonusNumber bonusNumber;

    private LotteryResult(final WinningLottoNumbers winningLottoNumbers, final BonusNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LotteryResult of(final WinningLottoNumbers winningLottoNumbers, final BonusNumber bonusNumber) {
        return new LotteryResult(winningLottoNumbers, bonusNumber);
    }

    public LotteryRankConstant judgeRank(final Lotto lotto) {
        List<Integer> userNumbers = lotto.getLottoNumbers()
                .stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> winningNumbers = winningLottoNumbers
                .getWinningLottoNumbers()
                .stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .toList();

        return calculateRank(userNumbers, winningNumbers);
    }

    private LotteryRankConstant calculateRank(List<Integer> userNumbers, final List<Integer> winningNumbers) {
        userNumbers.removeAll(winningNumbers);
        return judgeRankUsingDifferenceBetweenUserNumbersAndWinningNumbers(userNumbers);
    }

    private LotteryRankConstant judgeRankUsingDifferenceBetweenUserNumbersAndWinningNumbers(
            List<Integer> userNumbers) {
        if (isFirstRank(userNumbers)) {
            return LotteryRankConstant.FIRST_RANK;
        }
        if (isSecondRank(userNumbers)) {
            return LotteryRankConstant.SECOND_RANK;
        }
        if (isThirdRank(userNumbers)) {
            return LotteryRankConstant.THIRD_RANK;
        }
        if (isFourthRank(userNumbers)) {
            return LotteryRankConstant.FOURTH_RANK;
        }
        if (isFifthRank(userNumbers)) {
            return LotteryRankConstant.FIFTH_RANK;
        }
        return LotteryRankConstant.NONE;
    }

    private boolean isFirstRank(List<Integer> userNumbers) {
        return userNumbers.size() == RankDifferenceConstant.FIRST_RANK_DIFFERENCE_FROM_WINNING.getDifference();
    }

    private boolean isSecondRank(List<Integer> userNumbers) {
        return userNumbers.size() == RankDifferenceConstant.SECOND_RANK_DIFFERENCE_FROM_WINNING.getDifference()
                && userNumbers.contains(bonusNumber.getNumber());
    }

    private boolean isThirdRank(List<Integer> userNumbers) {
        return userNumbers.size() == RankDifferenceConstant.THIRD_RANK_DIFFERENCE_FROM_WINNING.getDifference()
                && !userNumbers.contains(bonusNumber.getNumber());
    }

    private boolean isFourthRank(List<Integer> userNumbers) {
        return userNumbers.size() == RankDifferenceConstant.FOURTH_RANK_DIFFERENCE_FROM_WINNING.getDifference();
    }

    private boolean isFifthRank(List<Integer> userNumbers) {
        return userNumbers.size() == RankDifferenceConstant.FIFTH_RANK_DIFFERENCE_FROM_WINNING.getDifference();
    }
}