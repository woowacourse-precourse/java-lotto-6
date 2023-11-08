package lotto.controller;

import lotto.domain.WinningNumber;

public class WinningNumberController {
    public static  void putWinningNums(String winningNums){
        WinningNumber.putWinningNums(winningNums);
    }
    public static void putBonusNum(String bonusNum){
        WinningNumber.putBonusNum(bonusNum);

    }
}
