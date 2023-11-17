package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    private LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket issueLottoTicket(int lottoCount) {
        List<Lotto> lottoNumbers = IntStream.range(0, lottoCount)
            .mapToObj(i -> Lotto.issueAutoPickNumbersLotto())
            .toList();
        return new LottoTicket(lottoNumbers);
    }

    public List<Lotto> getLottoTicket() {
        return List.copyOf(lottoTicket);
    }
}
