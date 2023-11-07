package lotto.domain;


import java.util.*;

import static lotto.constant.NumberConstants.SECOND_RANK_MATCH;
import static lotto.domain.LottoRank.NO_RANK;

public class LotteryChecker {

    private final LottoMachine lottoMachine;

    public LotteryChecker(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoResult calculateRank(WinningNumber winningNumber, BonusNumber bonusNumber) {
        List<Lotto> lottoPapers = lottoMachine.getLottoPapers();
        List<LottoRank> ranks = lottoPapers.stream()
                .map(lotto -> calculateMatchCount(lotto, winningNumber, bonusNumber))
                .toList();
        return new LottoResult(ranks);
    }

    public LottoRank calculateMatchCount(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        List<Integer> winNum = winningNumber.getWinningNumber();
        int matchCount = lotto.calculateMatchNumber(winNum);
        boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        return checkRank(matchCount, hasBonusNumber);
    }

    public static LottoRank checkRank(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> isPrize(rank, matchCount, isMatchBonus))
                .findAny()
                .orElse(NO_RANK);
    }

    private static boolean isPrize(LottoRank rank, int matchCount, boolean isMatchBonus) {
        if (rank.getMatchCount() != matchCount) {
            return false;
        }
        if (SECOND_RANK_MATCH == matchCount) {
            return rank.isMatchBonus() == isMatchBonus;
        }
        return true;
    }
}
