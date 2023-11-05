package lotto.view;

import java.util.List;
import lotto.constant.LottoMessage;

public class OutputView {

    public static void printLottoNumbers(List<Integer> numbers) {
        LottoMessage message = LottoMessage.LOTTO_NUMBERS_OUTPUT_MESSAGE;
        System.out.println(message.getMessage(numbers.toArray()));
    }
}
