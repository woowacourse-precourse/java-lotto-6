package lotto;

import java.util.List;

public class LottoTicketsDto {
    private final List<List<Integer>> lottos;
    private final Integer totalTickets;

    public LottoTicketsDto(List<List<Integer>> lottos, Integer totalTickets) {
        this.lottos = lottos;
        this.totalTickets = totalTickets;
    }

    public static LottoTicketsDto from(LottoTickets lottoTickets) {
        List<List<Integer>> lottos = lottoTickets.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                .toList();
        return new LottoTicketsDto(lottos, lottoTickets.getSize());
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}
