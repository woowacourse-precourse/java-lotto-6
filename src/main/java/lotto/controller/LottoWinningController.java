package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.service.LottoBonusMachine;
import lotto.service.LottoWinningMachine;

public class LottoWinningController {
    // 로또 당첨 통계를 중계할 클래스입니다.
    public void winningLotto() {
        LottoWinningMachine lottoWinningMachine = new LottoWinningMachine();
        Lotto winningNumber = lottoWinningMachine.lottoWinningNumber();

        LottoBonusMachine lottoBonusMachine = new LottoBonusMachine();
        BonusNumber bonus = lottoBonusMachine.lottoBonusNumber(winningNumber);

        System.out.println("winningNumber = " + winningNumber.getNumbers());
        System.out.println("bonus = " + bonus.getBonus());
    }
}