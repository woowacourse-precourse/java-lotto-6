package lotto.dto;

import static lotto.fixture.LottoFixture.lottoFixture;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void 로또의_개수를_반환한다() {
        // given
        int lottoCount = 10;
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoFixture())
                .toList();
        LottoTicket lottoTicket = new LottoTicket(lottos);

        // when
        int result = lottoTicket.count();

        // then
        assertThat(result).isEqualTo(lottoCount);
    }
}