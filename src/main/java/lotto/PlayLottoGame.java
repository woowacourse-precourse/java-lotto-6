package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InOutMessage;
import lotto.model.*;
import lotto.service.ProcessorHelper;
import lotto.validate.Validator;

public class PlayLottoGame {
    public static Validator validator = new Validator();

    private ProcessorHelper processorHelper = new ProcessorHelper();

    public void runLottoGame(){
        PurchaseInfo purchaseInfo = inputPurchaseCost();
        LottoArrays lottoArrays = printLottoNumber(purchaseInfo);
        NumberInfo numberInfo = inputWinnerAndBounsNumber();
        printLottoResult(lottoArrays, numberInfo);
    }

    private PurchaseInfo inputPurchaseCost(){
        System.out.println(InOutMessage.PURCHASE_COST_MESSAGE.getMessage());
        return new PurchaseInfo(Console.readLine());
    }

    private LottoArrays printLottoNumber(PurchaseInfo purchaseInfo){
        System.out.println(Integer.toString(purchaseInfo.getPurchaseCount()) + InOutMessage.PURCHASE_QUATITY_MESSAGE.getMessage());
        return processorHelper.createAndPrintLottoNumber(purchaseInfo);
    }
    private NumberInfo inputWinnerAndBounsNumber(){
        System.out.println(InOutMessage.WINNING_NUMBER_MESSAGE.getMessage());
        WinningNumber winningNumber = new WinningNumber(Console.readLine());

        System.out.println(InOutMessage.BONUS_NUMBER_MESSAGE.getMessage());
        BonusNumber bonusNumber = new BonusNumber(Console.readLine());

        return new NumberInfo(winningNumber, bonusNumber);
    }
    private void printLottoResult(LottoArrays lottoArrays, NumberInfo numberInfo){

        processorHelper.judgeAndPrintLottoResult(lottoArrays, numberInfo);
    }

}
