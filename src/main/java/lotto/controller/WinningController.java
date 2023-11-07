package lotto.controller;

import lotto.domain.WinningNumber;

public class WinningController {
    public static  void putWinningNums(String winningNums){
        WinningNumber.putWinningNum(winningNums);
    }
    public static void putBonusNum(String bonusNum){
        WinningNumber.putBonusNum(bonusNum);

    }
}
