package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private User user;

    public void start(){
        OutputView.printRequestPurchaseAmount();
        while(true) {
            try {
                Integer purchaseAmount = Integer.parseInt(InputView.inputPurchaseAmount());
                user = new User(purchaseAmount);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
