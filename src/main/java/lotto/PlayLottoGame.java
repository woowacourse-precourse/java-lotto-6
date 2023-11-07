package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InOutMessage;
import lotto.model.PurchaseInfo;
import lotto.validate.Validator;

public class PlayLottoGame {

    Validator validator = new Validator();

    public void runLottoGame(){
        inputPurchaseCost();
        printLottoNumber();
        inputWinnerAndBounsNumber();
        printLottoResult();
    }

    private int inputPurchaseCost(){
        System.out.println(InOutMessage.PURCHASE_COST_MESSAGE.getMessage());
        String purchaseCost = validator.validatePurchaseCost(Console.readLine());
        return Integer.parseInt(purchaseCost);
    }

    private void printLottoNumber(){

    }
    private void inputWinnerAndBounsNumber(){

    }
    private void printLottoResult(){

    }

}
