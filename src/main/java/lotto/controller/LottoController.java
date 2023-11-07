package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.LinkedHashMap;

public class LottoController {

    private static User user;
    private static WinningNumber winningNumber;
    private static BonusNumber bonusNumber;

    public void start(){
        inputPurchaseAmount();
        purchaseLotto();
        inputWinningNumber();
        inputBonusNumber();
        Result result = checkUserNumber();
        printResult(result);
    }



    private void inputPurchaseAmount() {
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
    }

    private void purchaseLotto() {
        OutputView.printLottoQuantity(user.getLottoQuantity());
        OutputView.printLottoNumber(user.getLottos());
    }

    private void inputWinningNumber() {
        OutputView.printRequestWinnerNumberMessage();
        while(true){
            try{
                winningNumber = new WinningNumber(InputView.inputWinningNumber());
                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        OutputView.printRequestBonusNumberMessage();
        while(true){
            try{
                bonusNumber = new BonusNumber(winningNumber.getWinningNumber(),InputView.inputBonusNumber());
                break;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private Result checkUserNumber() {
        Result result = new Result(new LinkedHashMap<>());
        for(Lotto lotto : user.getLottos()) {
            result.compare(lotto.getNumbers(), winningNumber.getWinningNumber(), bonusNumber.getBonusNumber());
        }
        return result;
    }

    private void printResult(Result result) {
        OutputView.printResult(result);
        OutputView.printProfitRate(result.getProfitRate(user.getPurchaseAmount()));
    }
}