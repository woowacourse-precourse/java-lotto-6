package lotto.service;

import lotto.constant.Message.OutputMessage;
import lotto.constant.Sign;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;

public class OutputService {
    public void printLottos(Lottos lottos, Buyer buyer) {
        String message = String.format(OutputMessage.SHOW_PURCHASED_LOTTO_NUMBER.getOutputMessage(), buyer.getNumberOfLotto());
        System.out.println(message);
        ArrayList<Lotto> allLottos = lottos.getLottos();
        for (int i = 0; i < allLottos.size(); i++) {
            System.out.println(allLottos.get(i));
        }
        System.out.println(Sign.LINE_BREAKER.getSign());
    }
}
