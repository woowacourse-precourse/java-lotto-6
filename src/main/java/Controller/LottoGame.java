package Controller;

import View.UserInput;
import lotto.Lotto;

import java.util.List;

public class LottoGame {
    public LottoGame(){

    }
    private static UserInput userInput=new UserInput();
    private static List<Integer> winningLottoNum;
    private static Integer winningBonusNum;
    public void gameStart(){
        //1. User에게 입력을 받는다.
        Integer purchaseAmount= userInput.getPurchaseAmount();
        Lotto lotto =userInput.getWinningNum();
        winningBonusNum= userInput.getBonusNum();
    }
}
