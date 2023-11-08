package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.message.OutPutMessage;

public class OutPutView {
    public void printBuyingPriceResult(int lottoCount) {
        String result = String.format(OutPutMessage.BUYING_COUNT_FORMAT.getValue(), lottoCount);
        System.out.println(result);
    }

    public void printLottoTickets(Lottos lottoTickets) {
        System.out.println(lottoTickets);
        System.out.println();
    }

}
