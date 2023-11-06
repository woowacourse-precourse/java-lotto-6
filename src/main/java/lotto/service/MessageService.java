package lotto.service;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        sortNumbers.sort(Comparator.naturalOrder());
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < sortNumbers.size(); i++) {
            stringBuilder.append(sortNumbers.get(i));
            if (i < sortNumbers.size() - 1) {
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
        String message = String.format(OutputMessage.OUTPUT_LOTTO_STATUS_MESSAGE.getMessage(), number, formatPrice,
                resultCount);
        System.out.println(message);
    }

    public void outputLottoWithBonusStatus(int number, String formatPrice, int resultCount) {
        String message = String.format(OutputMessage.OUTPUT_LOTTO_WITH_BONUS_STATUS_MESSAGE.getMessage(), number - 10,
                formatPrice, resultCount);
        System.out.println(message);
    }

    public void outputLottoReturnRate(double lottoReturn) {
        String message = String.format(OutputMessage.OUTPUT_LOTTO_RETURN_RATE_MESSAGE.getMessage(), lottoReturn);
        System.out.println(message);
    }
}
