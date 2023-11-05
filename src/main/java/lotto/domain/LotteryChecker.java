package lotto.domain;

import lotto.constant.NumberConstants;

import java.util.*;
import java.util.stream.Collectors;

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
        return LottoRank.checkRank(matchCount,
                lotto.getNumbers().contains(bonusNumber.getBonusNumber()));
    }
}
