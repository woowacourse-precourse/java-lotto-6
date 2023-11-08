package lotto.controller;

import lotto.domain.WinningNumber;

public class WinningNumberController {

    private final WinningNumber winningNumber = WinningNumber.getInstance();
    private WinningNumberController() {
    }

    private static class WinningNumberControllerHolder{
        private static final WinningNumberController winningNumberController = new WinningNumberController();
    }

    public static WinningNumberController getInstance(){
        return WinningNumberControllerHolder.winningNumberController;
    }

    public void putWinningNums(String winningNums){
        winningNumber.putWinningNums(winningNums);
    }
    public void putBonusNum(String bonusNum){
        winningNumber.putBonusNum(bonusNum);

    }
}
