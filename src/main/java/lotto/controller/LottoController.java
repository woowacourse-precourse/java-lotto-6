package lotto.controller;

import lotto.model.User;

import java.util.List;

public class LottoController {
    public void StartGame(){
        User user = new User();
        int purchaseAmount = user.inputPurchaseAmount();
        List<Integer> correctNumber = user.inputLottoNumber();

        System.out.println(purchaseAmount);
        System.out.println(correctNumber);
    }
}
