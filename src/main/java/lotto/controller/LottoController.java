package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.service.validator.PurchaseAmount;
import lotto.view.LottoView;

public class LottoController {

    private LottoView lottoView = new LottoView();
    private PurchaseAmount purchaseAmount = new PurchaseAmount();
    private Parser parser = new Parser();
    private int purchaseAmountNum;
    public void startLotto(){
        purchaseAmountNum = processPurchaseAmount();
    }

    public int processPurchaseAmount(){
        String purchaseNum;
        while(true){
            try{
                purchaseNum = getPurchaseAmount();
                validatePurchaseAmount(purchaseNum);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return parser.stringToInt(purchaseNum);
    }

    public String getPurchaseAmount(){
        String purchaseNum;

        lottoView.purchaseAmountView();
        purchaseNum = Console.readLine();

        return purchaseNum;
    }

    public void validatePurchaseAmount(String input){
        purchaseAmount.validateNotInteger(input);
        purchaseAmount.validateUnderThousand(input);
        purchaseAmount.validateNotRemainZero(input);
    }
}
