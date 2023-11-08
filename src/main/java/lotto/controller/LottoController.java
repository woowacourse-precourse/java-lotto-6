package lotto.controller;

import lotto.model.Lotto;
import lotto.model.User;

import java.util.List;

public class LottoController {
    public void StartGame(){
        User user = new User();
        int purchaseAmount = user.inputPurchaseAmount();
        while (true){
            List<Integer> correctNumber = user.inputLottoNumber();
            try {
                Lotto lotto = new Lotto(correctNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
