package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.ConstantsMessage;

public class OutputView {
    public void printMessage(ConstantsMessage constant) {
        System.out.println(constant.message);
    }

    public void printPrizeResult(String result) {
        printMessage(ConstantsMessage.LOTTO_RESULT_HEADER);
        printMessage(ConstantsMessage.LOTTO_RESULT_SECTION);
        System.out.println(result);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
