package lotto.view;

import java.text.MessageFormat;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.IOMessage;
import lotto.model.Lotto;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(ErrorMessage.format(message));
    }

    public void printLottoCountMessage(int count) {
        System.out.println(MessageFormat.format(IOMessage.OUTPUT_LOTTO_COUNT_MESSAGE, count));
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(MessageFormat.format(IOMessage.OUTPUT_LOTTO_NUMBER_MESSAGE, lotto.getNumbersAsString()));
    }
}
