package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    void 구입한_로또수만큼_로또를_생성하는_기능_테스트() {
        LottoTicket lottoTicket = new LottoTicket(3000);
        List<Lotto> lottos = lottoTicket.generateLottos();
        assertThat(lottos.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {10001, 100})
    void 나누어떨어지지_않는값_예외처리_테스트(int input) {
        assertThatThrownBy(() -> new LottoTicket(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
