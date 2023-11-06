package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static User user;
    private static WinningNumber winningNumber;
    private static BonusNumber bonusNumber;

    public void start(){
        OutputView.printRequestPurchaseAmount();
        while(true) {
            try {
                Integer purchaseAmount = Integer.parseInt(InputView.inputPurchaseAmount());
                user = new User(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        OutputView.printLottoQuantity(user.getLottoQuantity());
        OutputView.printLottoNumber(user.getLottos());

        while(true){
            try{
                winningNumber = new WinningNumber(InputView.inputWinningNumber());
                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try{
                bonusNumber = new BonusNumber(InputView.inputBonusNumber());
                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}