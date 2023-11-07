package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.service.*;
import lotto.view.TotalMarginView;
import lotto.view.WinningStatisticsView;

import java.util.List;
import java.util.Map;


public class LottoWinningController {
    // 로또 당첨 통계를 중계할 클래스입니다.
    public void winningLotto(List<Lotto> purchasedLotto) {
        Map<Match, Integer> matchCount = matchCount(purchasedLotto);
        WinningStatisticsView winningStatisticsView = new WinningStatisticsView();
        winningStatisticsView.printWinningStatistics(matchCount);

        double totalMargin = totalMargin(matchCount);
        TotalMarginView totalMarginView = new TotalMarginView();
        totalMarginView.printTotalMargin(totalMargin);
    }

    private double totalMargin(Map<Match, Integer> matchCount) {
        TotalMarginCalculator totalMarginCalculator = new TotalMarginCalculator();

        return totalMarginCalculator.totalMarginCalculator(matchCount);
    }

    private Map<Match, Integer> matchCount(List<Lotto> purchasedLotto) {
        Lotto winningNumber = winningNumber();
        BonusNumber bonus = bonus(winningNumber);

        List<Match> matches = matches(purchasedLotto, winningNumber, bonus);

        LottoTotalCount lottoTotalCount = new LottoTotalCount();
        Map<Match, Integer> matchCount = lottoTotalCount.getTotalCount(matches);

        return matchCount;
    }

    private Lotto winningNumber() {
        LottoWinningMachine lottoWinningMachine = new LottoWinningMachine();
        Lotto winningNumber = lottoWinningMachine.lottoWinningNumber();

        return winningNumber;
    }

    private BonusNumber bonus(Lotto winningNumber) {
        LottoBonusMachine lottoBonusMachine = new LottoBonusMachine();
        BonusNumber bonus = lottoBonusMachine.lottoBonusNumber(winningNumber);

        return bonus;
    }

    private List<Match> matches(List<Lotto> purchasedLotto, Lotto winningNumber, BonusNumber bonus) {
        LottoMatchNumber lottoMatchNumber = new LottoMatchNumber();
        List<Match> matches = lottoMatchNumber.lottoMatch(purchasedLotto, winningNumber, bonus);

        return matches;
    }
}