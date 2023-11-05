package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoGuideMessage;

public class OutputView {

    public void showMessage(String message) {
        System.out.println(message);
    }
    public void showMessage(LottoGuideMessage lottoGuideMessage) {
        System.out.println(lottoGuideMessage.getMessage());
    }

    public void showIssueLottoTickets(List<Lotto> lottoTickets) {
        String purchaseCountMessage =
                String.format(LottoGuideMessage.PURCHASE_COUNT_INFO.getMessage(), lottoTickets.size());
        System.out.println(purchaseCountMessage);
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }
}
