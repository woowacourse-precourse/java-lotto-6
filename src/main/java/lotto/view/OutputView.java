package lotto.view;

import lotto.domain.Lotto;
import lotto.message.ResponseMessage;

import java.util.List;

public class OutputView {
    public void responseLottos(List<Lotto> lottos) {
        String boughtMessage = String.format(ResponseMessage.BOUGHT_MESSAGE, lottos.size());
        System.out.println(boughtMessage);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
