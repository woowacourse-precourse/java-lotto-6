package Controller;

import View.UserInput;

import java.util.List;

public class LottoGame {
    public void gameStart(){
        UserInput userInput=new UserInput();
        List<Integer> winningNum=userInput.getWinningNum();
        Integer purchaseAmount= userInput.getPurchaseAmount();
    }
}
