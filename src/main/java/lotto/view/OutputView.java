package lotto.view;

import lotto.message.Message;
import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.List;

import static lotto.constant.StringConstant.COMMA_SPACE;
import static lotto.message.ErrorMessage.ERROR_PREFIX;
import static lotto.message.LottoMessage.DISPLAY_LOTTO_NUMBER_FORMAT;

public class OutputView {

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(IllegalArgumentException e) {
        String errorFormatMessage = ErrorMessageFormat(e.getMessage());
        printMessage(errorFormatMessage);
    }

    public String ErrorMessageFormat(String errorMessage) {
        return String.format(ERROR_PREFIX.getMessage(), errorMessage);
    }

    public void printLottoCount(Message message, int purchaseCost) {
        System.out.printf(message.getMessage(), purchaseCost);
    }

    public void printPurchaseLottos(Lottos lottos) {
        List<Lotto> purchaseLottos = lottos.getLottos();
        purchaseLottos.forEach(lotto -> printLottoNumber(lotto));
    }

    private void printLottoNumber(Lotto lotto) {
        String joinNumberWithDelimiter = lotto.joinNumbersWithDelimiter(COMMA_SPACE);
        String LottoNumberFormat = String.format(DISPLAY_LOTTO_NUMBER_FORMAT.getMessage(), joinNumberWithDelimiter);
        printMessage(LottoNumberFormat);
    }


}
