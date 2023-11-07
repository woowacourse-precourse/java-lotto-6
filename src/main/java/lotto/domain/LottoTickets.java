package lotto.domain;

import lotto.dto.PurchaseResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> purchaseTickets;

    public static LottoTickets create(List<PurchaseResult> tickets) {
        List<Lotto> purchaseTickets = tickets.stream()
                .map(PurchaseResult::lottoNumbers)
                .map(Lotto::of)
                .collect(Collectors.toList());

        return new LottoTickets(purchaseTickets);
    }

    private LottoTickets(List<Lotto> purchaseTickets) {
        this.purchaseTickets = purchaseTickets;
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(purchaseTickets);
    }
}
