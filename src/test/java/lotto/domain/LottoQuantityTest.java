package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoQuantityTest {
    @Test
    @DisplayName("로또를 티켓수만큼 생성한다.")
    void metodName() throws Exception {
        //given
        int tickets = 8;
        //when
        List<Lotto> lottos = new LottoQuantity(tickets).getLottos();
        //then
        assertThat(lottos.size()).isEqualTo(8);
    }

}