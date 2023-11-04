package lotto.service;

import java.util.List;
import lotto.constant.InputMessage;
import lotto.constant.OutputMessage;

public class MessageService {
    public void inputPurchasePrice() {
        System.out.println(InputMessage.INPUT_PURCHASE_PRICE.getMessage());
    }

    public void outputPurchaseAmount(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount + OutputMessage.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void outputPurchaseNumbers(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public void inputWinningNumberMessage() {
        System.out.println();
        System.out.println(InputMessage.INPUT_WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void inputBonusNumberMessage() {
        System.out.println();
        System.out.println(InputMessage.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void outputResultMessage() {
        System.out.println();
        System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
    }

    public void outputLottoStatus(int number, String formatPrice, int resultCount) {
        if (number > 10) {
            number -= 10;
        }
        String message = String.format(OutputMessage.OUTPUT_LOTTO_STATUS_MESSAGE.getMessage(), number, formatPrice,
                resultCount);
        System.out.println(message);
    }
}
