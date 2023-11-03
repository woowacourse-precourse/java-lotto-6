package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(int numberOfTickets) {
        lottoTickets = IntStream.range(0, numberOfTickets)
                // TODO: 랜던 유니크 생성 적용 하기
                .mapToObj(i -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .collect(Collectors.toList());
    }

}
