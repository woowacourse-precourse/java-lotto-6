package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.enums.Message;

public class OutputView {
    public void printBuyingPriceResult(int lottoCount) {
        String result = String.format(Message.BUY_LOTTO_COUNT_MESSAGE.getValue(), lottoCount);
        System.out.println(result);
    }

    public void printLottoTickets(Lottos lottoTickets) {
        System.out.println(lottoTickets);
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println(Message.RESULT_MESSAGE.getValue());
        System.out.println(result);
    }
}
