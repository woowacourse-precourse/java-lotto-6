package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @DisplayName("생성 테스트")
    @Test
    void createLottoCollection() {
        LottoTickets lottoTickets = new LottoTickets(5);
    }
    @Test
    void forLoopToStream() {
        List<Integer> lottoTickets = new ArrayList<>();
        List<Integer> lottoTickets2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoTickets.add(i);
        }
        IntStream.range(0, 10).forEach(lottoTickets2::add);

        assertThat(lottoTickets.equals(lottoTickets2)).isTrue();
    }

    @Test
    void forLoopToStreamRangeMapToObj() {
        final List<Lotto> lottoTickets;

        final List<Lotto> lottoTickets1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoTickets1.add(new Lotto(List.of(1,2,3,4,5,6)));
        }
        lottoTickets = lottoTickets1;
        //
        final List<Lotto> lottoTickets2 = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> lottoTickets2.add(new Lotto(List.of(1,2,3,4,5,6))));
        //
        final List<Lotto> lottoTickets3;

        lottoTickets3 = IntStream.range(0,10)
                .mapToObj(i -> new Lotto(List.of(1,2,3,4,5,6)))
                .collect(Collectors.toList());

        assertThat(lottoTickets2.equals(lottoTickets3)).isFalse();
    }
}