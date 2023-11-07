package lotto.service;

import lotto.exception.BonusException;
import lotto.exception.CountException;
import lotto.exception.WinningException;

import java.util.List;

public class ExceptionService {
    private static BonusException bonusException = new BonusException();
    private static CountException countException = new CountException();
    private static WinningException winningException = new WinningException();

    public void checkBonus(String readLine, List<Integer> winningNumber){
        bonusException.isItNumber(readLine);
        bonusException.isItContainSameNumber(readLine, winningNumber);
        bonusException.isItCheckedRange(readLine);
    }

    public void checkCount(String readLine){
        countException.isItNumber(readLine);
        countException.isItPositiveNumber(readLine);
        countException.isIt1000wonUnit(readLine);
    }

    public void checkWinning(String readLine){
        winningException.isItCountOfNumber(readLine);
        winningException.isItCheckedRange(readLine);
        winningException.isItContainSameNumber(readLine);
    }

}
