package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmount purchaseAmount = new PurchaseAmount();

        while(true) {
            try {
                purchaseAmount.print_inputAmount();
                purchaseAmount.inputAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage() + "\n");
            }
        }

        LottoList lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.print_numberOfLottoList();
        lottoList.createLottoList();
        lottoList.printLottoList();


    }
}
