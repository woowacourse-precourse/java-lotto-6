
package lotto.domain;

import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public record LottoPaper (int amount, List<Lotto>lottoTickets){
    public LottoPaper{
        lottoTickets = Collections.unmodifiableList(lottoTickets);
    }
}
