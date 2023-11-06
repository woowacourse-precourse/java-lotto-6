package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void 전달받은_로또_갯수만큼_저장한다() {
        //given
        List<Lotto> collect = IntStream.range(0, 5)
                .mapToObj(i -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .collect(Collectors.toList());
        //when
        LottoTicket lottoTicket = new LottoTicket(collect);
        //then
        assertThat(lottoTicket.getLottos().size()).isEqualTo(5);
    }
}
