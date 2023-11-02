package lotto.io;

import java.util.List;

public class Output {

    public void printInputPurchaseAmountMessage() {
        System.out.println(Constants.PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseQuantity(int lottoQuantity) {
        System.out.println();
        System.out.printf(Constants.QUANTITY_MESSAGE, lottoQuantity);
    }

    public void printMyLottos(List<String> myLottos) {
        for (String lottoNumbers : myLottos) {
            System.out.println(lottoNumbers);
        }
    }

    public void printInputWinningNumbersMessage() {
        System.out.println();
        System.out.println(Constants.INPUT_WINNING_NUMBERS);
    }
}

