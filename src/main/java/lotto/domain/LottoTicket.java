package lotto.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.List;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;

public record LottoTicket(List<Lotto> lottoTicket) {
    public int count() {
        return lottoTicket.size();
    }

    public List<Lotto> lottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    public WinningResult match(final WinningLotto winningLotto) {
        return lottoTicket.stream()
                .map(lotto -> lotto.match(winningLotto.lotto(), winningLotto.bonus()))
                .collect(collectingAndThen(toMap(prize -> prize, prize -> 1, Integer::sum), WinningResult::new));
    }
}
