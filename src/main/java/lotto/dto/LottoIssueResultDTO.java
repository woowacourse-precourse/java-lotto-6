package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoIssueResultDTO {
    private final int ticketCount;
    private final List<Lotto> lottos;

    private LottoIssueResultDTO(int ticketCount, List<Lotto> lottos) {
        this.ticketCount = ticketCount;
        this.lottos = lottos;
    }

    public static LottoIssueResultDTO of(int ticketCount, List<Lotto> lottos) {
        return new LottoIssueResultDTO(ticketCount, lottos);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<String> getLottos() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .collect(Collectors.toList());
    }
}
