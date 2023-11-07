package lotto;

import java.util.List;
import java.util.stream.IntStream;

public record LottoTicket(List<Lotto> lottos) {

    public static LottoTicket issueLottoTicket(int lottoCount) {
        List<Lotto> lottoNumbers = IntStream.range(0, lottoCount)
            .mapToObj(i -> Lotto.issueLotto())
            .toList();
        return new LottoTicket(lottoNumbers);
    }
}
