package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InOutMessage;
import lotto.model.LottoArrays;
import lotto.model.PurchaseInfo;
import lotto.service.ProcessorHelper;
import lotto.validate.Validator;

public class PlayLottoGame {

    Validator validator = new Validator();
    ProcessorHelper processorHelper = new ProcessorHelper();

    public void runLottoGame(){
        PurchaseInfo purchaseInfo = new PurchaseInfo(inputPurchaseCost());
        printLottoNumber(purchaseInfo.getPurchaseCount());
        inputWinnerAndBounsNumber();
        printLottoResult();
    }

    private int inputPurchaseCost(){
        System.out.println(InOutMessage.PURCHASE_COST_MESSAGE.getMessage());
        String purchaseCost = validator.validatePurchaseCost(Console.readLine());
        return Integer.parseInt(purchaseCost);
    }

    private void printLottoNumber(int purchaseCount){
        System.out.println(Integer.toString(purchaseCount) + InOutMessage.PURCHASE_QUATITY_MESSAGE.getMessage());
        LottoArrays lottoArrays = processorHelper.createLottoNumber(purchaseCount);
        processorHelper.printLottoArrays(lottoArrays);
    }
    private void inputWinnerAndBounsNumber(){

    }
    private void printLottoResult(){

    }

}
