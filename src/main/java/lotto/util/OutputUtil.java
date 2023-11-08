package lotto.util;

import static lotto.message.SystemMessage.OUTPUT_PURCHASE_LOTTO_AMOUNT;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.UserInputException;
import lotto.message.SystemMessage;
import lotto.view.OutputView;

public class OutputUtil {

    private OutputUtil() {
    }

    public static String formatSystemMessageWithNumber(SystemMessage systemMessage, int num) {
        return String.format(systemMessage.getMessage(), num);
    }
}
