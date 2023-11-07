package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoPublisherTest {

    @Test
    void 수량에_따라_로또를_여러_개_발행하는_기능_테스트() {
        //given
        int issueAbleCount = 6;

        //when
        LottoPublisher lottoPublisher = new LottoPublisher(issueAbleCount);

        //then
        Assertions.assertThat(lottoPublisher.getLottos().size()).isEqualTo(issueAbleCount);
    }
}