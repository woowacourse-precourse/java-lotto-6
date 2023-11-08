package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @DisplayName("주어진 구입 개수만큼 로또 티켓을 생성한다.")
    @Test
    void generateLottoTickets() {
        // given
        int lottoAmount = 8;
        LottoGenerator lottoGenerator = new LottoGenerator();

        // when
        List<Lotto> lottoTickets = lottoGenerator.generateLottoTickets(lottoAmount);

        // then
        assertThat(lottoTickets.size()).isEqualTo(8);
    }
}