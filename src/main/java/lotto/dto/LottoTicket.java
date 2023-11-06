package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record LottoTicket(List<Lotto> lottoTicket) {
    public int count() {
        return lottoTicket.size();
    }
}
