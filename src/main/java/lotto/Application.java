package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        inputPurchaseAmount(purchaseAmount);

        LottoList lottoList = new LottoList(purchaseAmount.getAmount());
        lottoList.printNumberOfLotto();
        lottoList.createLottoList();
        lottoList.printLottoList();

        CorrectLotto correctLotto = new CorrectLotto();
        inputCorrectLotto(correctLotto);
        inputBonus(correctLotto);

        DrawLotto drawLotto = new DrawLotto(lottoList, correctLotto);
        drawLotto.draw();
        drawLotto.calculateProfitPercentage(purchaseAmount.getAmount());
        drawLotto.printStatistics();
    }

    private static void inputPurchaseAmount(PurchaseAmount purchaseAmount){
        while(true) {
            try {
                purchaseAmount.printInputAmountMessage();
                String input_amount = readLine();
                purchaseAmount.inputAmount(input_amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage() + "\n");
            }
        }
    }

    private static void inputCorrectLotto(CorrectLotto correctLotto){
        while(true){
            try{
                correctLotto.printInputNumbersMessage();
                String input_numbers = readLine();
                correctLotto.inputCorrectLotto(input_numbers);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void inputBonus(CorrectLotto correctLotto){
        while(true){
            try{
                correctLotto.printInputBonusMessage();
                String input_number = readLine();
                correctLotto.inputBonus(input_number);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
