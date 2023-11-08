package Controller;

import Model.PurchaseLotto;
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
        //1. User에게 구매 가격 입력을 받는다.
        Integer purchaseAmount= userInput.getPurchaseAmount();
        // User가 구입한 장수, 로또 보여준다.
        PurchaseLotto userPurchaseLottos=new PurchaseLotto(purchaseAmount);
        //당첨 번호 6개를 입력받는다.
        Lotto lotto =userInput.getWinningNum();
        //보너스 번호 1개를 입력받는다.
        winningBonusNum= userInput.getBonusNum();
    }
}
