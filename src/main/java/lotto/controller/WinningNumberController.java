package lotto.controller;

import lotto.domain.WinningNumber;

public class WinningNumberController {
    public WinningNumberController() {
    }

    private static class WinningNumberControllerHolder{
        private static final WinningNumberController winningNumberController = new WinningNumberController();
    }

    public  static WinningNumberController getInstance(){
        return WinningNumberControllerHolder.winningNumberController;
    }

    public   void putWinningNums(String winningNums){
        WinningNumber.putWinningNums(winningNums);
    }
    public  void putBonusNum(String bonusNum){
        WinningNumber.putBonusNum(bonusNum);

    }
}
