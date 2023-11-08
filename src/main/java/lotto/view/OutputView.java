package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;

import java.util.List;

public class OutputView {

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public static void printPurchaseLottoResult(final LottoTicket ticket) {
        List<Lotto> lottos = ticket.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto);
        }
    }
    public static void printLottoNumbers(Lotto lotto){
        System.out.println(lotto.getLottoNumbers());
    }
}
