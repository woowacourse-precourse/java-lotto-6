package lotto.util;

import static lotto.message.SystemMessage.OUTPUT_PURCHASE_LOTTO_AMOUNT;

import lotto.message.SystemMessage;
import lotto.view.OutputView;

public class OutputUtil {
    public static void outputLottoAmount(int amount){
        String output = formatMessageWithNumber(OUTPUT_PURCHASE_LOTTO_AMOUNT, amount);
        OutputView.print(output);
    }

    private static String formatMessageWithNumber(SystemMessage systemMessage, int num) {
        return String.format(systemMessage.getMessage(), num);
    }
}
