package lotto.domain.purchase.issue;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LotteryIssueService {
    public Lottos issueLottoAmountOf(Integer lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = LottoIssuer.issueLotto();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
