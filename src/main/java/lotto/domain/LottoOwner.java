package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoOwner {
    List<Lotto> lottos;

    public int purchaseLotto(int money) {
        LottoTicket lottoTicket = new LottoTicket(money);
        lottos = lottoTicket.generateLottos();
        return lottoTicket.getTicketNumber();
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
    }
}
