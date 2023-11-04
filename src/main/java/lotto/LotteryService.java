package lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryService {
    private int totalLottoAmount;
    List<Lotto> buyLottoSet = new ArrayList<Lotto>();
    Validation validator = new Validation();

    public LotteryService(){
        this.totalLottoAmount = 0;
    }

    public void purchaseLotto(){
        DataInput inputPurchasePayment = new DataInput();
        DataOutput outputMessage = new DataOutput();
        int totalPurchasePayment;

        outputMessage.printProgressMessage(Progress.PURCHASE);
        totalPurchasePayment = inputPurchasePayment.userInputPayment();

        if(!validator.isPaymentDivided(totalPurchasePayment)){
            throw new IllegalArgumentException();
        }

        this.totalLottoAmount = totalPurchasePayment / 1000;
    }
}
