package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoTicket {

    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket issueLottoTicket(int lottoCount) {
        List<Lotto> lottoNumbers = IntStream.range(0, lottoCount)
            .mapToObj(i -> Lotto.issueAutoPickNumbersLotto())
            .toList();
        return new LottoTicket(lottoNumbers);
    }
}
