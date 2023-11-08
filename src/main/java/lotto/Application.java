package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.printInputAmountMessage();
        purchaseAmount.inputAmount();

        LottoList lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.printNumberOfLotto();
        lottoList.createLottoList();
        lottoList.printLottoList();


    }
}
