package lotto;

import java.util.List;

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

        Lottoes lottoes = new Lottoes(purchaseAmount.getAmount() / 1000);
        lottoes.print_numberOfLottoes();
        try {
            lottoes.createLottoes();
        } catch (Exception e){
            e.printStackTrace();
        }

        lottoes.printLottoes();
    }
}
