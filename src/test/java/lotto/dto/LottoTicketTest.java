package lotto.dto;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.fixture.LottoFixture.lottoFixture;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void 로또의_개수를_반환한다() {
        // given
        int lottoCount = 10;
        LottoTicket lottoTicket = IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoFixture())
                .collect(collectingAndThen(toList(), LottoTicket::new));

        // when
        int result = lottoTicket.count();

        // then
        assertThat(result).isEqualTo(lottoCount);
    }
}