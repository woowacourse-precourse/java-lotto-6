package lotto.view;

import lotto.constants.SystemMessage;
import lotto.domain.Lottos;

public class Output {
    public static void ShowLottos(Lottos lottos){
        System.out.printf(SystemMessage.LOTTO_AMOUNT.getMessage(), lottos.getAmount());
        System.out.printf(lottos.getLottoStrings());
        System.out.printf(SystemMessage.EMPTY_STRING.getMessage());

    }
}
