package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPublisherTest {

    @Test
    @DisplayName("성공적으로 로또를 발행 해야 한다")
    public void 성공적으로_로또를_발행_해야_한다() {
        LottoPublisher lottoPublisher = new LottoPublisher();

        List<Lotto> lottos = lottoPublisher.publishLotto(8000L);

        assertThat(lottos).hasSize(8);
    }

}
