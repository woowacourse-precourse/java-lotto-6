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
        LottoWinningMachine lottoWinningMachine = new LottoWinningMachine();
        Lotto winningNumber = lottoWinningMachine.lottoWinningNumber();

        LottoBonusMachine lottoBonusMachine = new LottoBonusMachine();
        BonusNumber bonus = lottoBonusMachine.lottoBonusNumber(winningNumber);

        LottoMatchNumber lottoMatchNumber = new LottoMatchNumber();
        List<Match> matches = lottoMatchNumber.lottoMatch(purchasedLotto, winningNumber, bonus);

        LottoTotalCount lottoTotalCount = new LottoTotalCount();
        Map<Match, Integer> matchCount = lottoTotalCount.getTotalCount(matches);

        WinningStatisticsView winningStatisticsView = new WinningStatisticsView();
        winningStatisticsView.printWinningStatistics(matchCount);

        TotalMarginCalculator totalMarginCalculator = new TotalMarginCalculator();
        TotalMarginView totalMarginView = new TotalMarginView();
        totalMarginView.printTotalMargin(totalMarginCalculator.totalMarginCalculator(matchCount));
    }
}