package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    public String requestPurchasePrice() {
        printConstantMessage(LottoViewConstantMessages.PURCHASE_PRICE_REQUEST_MESSAGE);
        return readLine();
    }

    public void printPurchasedQuantity(int quantity) {
        System.out.print(quantity);
        printConstantMessage(LottoViewConstantMessages.PURCHASED_QUANTITY_MESSAGE);
    }

    public String requestWinningNumbers() {
        printConstantMessage(LottoViewConstantMessages.BONUS_NUMBER_REQUEST_MESSAGE);
        return readLine();
    }

    private void printConstantMessage(LottoViewConstantMessages lottoViewConstantsMessage) {
        System.out.println(lottoViewConstantsMessage.getMessage());
    }

}
