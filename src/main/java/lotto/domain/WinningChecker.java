package lotto.domain;

import lotto.values.CorrectNumber;
import lotto.vo.BonusNumber;
import lotto.vo.Lotto;
import lotto.vo.WinningNumber;
import lotto.vo.WinningResult;

import java.util.List;


public class WinningChecker {
    WinningResult winningResult;
    public WinningChecker(WinningNumber w, BonusNumber b, List<Lotto> lottoPackage){
        winningResult = new WinningResult();
        for(Lotto lotto: lottoPackage){
            CorrectNumber place = w.compareLotto(lotto);
            if(place!=null) winningResult.win(place);
        }
    }
}
