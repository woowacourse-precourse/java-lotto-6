package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
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


        OutputView.printRequestWinnerNumberMessage();
        while(true){
            try{
                winningNumber = new WinningNumber(InputView.inputWinningNumber());
                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        OutputView.printRequestBonusNumberMessage();
        while(true){
            try{
                bonusNumber = new BonusNumber(winningNumber.getWinningNumber(),InputView.inputBonusNumber());
                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        Result result = new Result(new LinkedHashMap<>());
        for(Lotto lotto : user.getLottos()) {
            result.compare(lotto.getNumbers(), winningNumber.getWinningNumber(), bonusNumber.getBonusNumber());
        }
        OutputView.printResult(result);
        result.getProfitRate(user.getPurchaseAmount());
    }
}