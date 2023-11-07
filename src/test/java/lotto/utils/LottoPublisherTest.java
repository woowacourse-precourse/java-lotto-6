package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("로또 발행 클래스에")
class LottoPublisherTest {

    private final LottoPublisher lottoPublisher = new LottoPublisher();

    @DisplayName("발행 요청시 구입 금액에 맞는 개수를 발행한다.")
    @Test
    void publish() {
        // given
        // when
        final int expected = 2000;
        final Lottos lottos = lottoPublisher.publish(new PurchaseAmount(expected));

        // then
        final List<Lotto> elements = lottos.toElements();
        assertThat(elements).hasSize(expected / 1000);
    }
}
