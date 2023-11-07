package lotto.domain.purchase.issue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.view.OutputView;

public class LotteryIssueService {
    public List<Lotto> getLottos(Integer ticketCount) {
        // 로또 티켓 발행
        List<Lotto> lottos = issueLottoAmountOf(ticketCount);
        // 로또 티켓 출력 뷰
        String lottosState = lottos.stream().map(Lotto::toString).collect(Collectors.joining());
        OutputView.printLottos(lottosState);
        return lottos;
    }

    /***
     * {@link LottoIssuer}에게 발행 역할 위임
     */
    List<Lotto> issueLottoAmountOf(Integer lottoTicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = LottoIssuer.issueLotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
