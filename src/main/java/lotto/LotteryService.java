package lotto;

public class LotteryService {
    private int totalLottoAmount;
    Validation validator = new Validation();
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

    public LotteryService(){
        this.totalLottoAmount = 0;
    }
}
