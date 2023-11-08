package lotto.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class LottoAgency {

    private static final RandomUtils randomUtils = new GenerateRandomLottoNumbers();

    public static LottoTicket createAutoTicket(int quantity) {
        return new LottoTicket(
                IntStream.range(0, quantity)
                        .mapToObj(i -> new Lotto(randomUtils))
                        .collect(Collectors.toList())
        );
    }
}
