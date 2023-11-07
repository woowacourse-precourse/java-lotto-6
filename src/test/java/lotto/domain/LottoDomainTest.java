package lotto.domain;

import lotto.model.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoDomainTest {

    LottoDomain lottoDomain = new LottoDomain();

    @Test
    void createLottosTest() {
        //given
        int purchaseCount = 3;

        //when
        Lottos lottos = lottoDomain.createLottos(purchaseCount);

        //then
        Assertions.assertThat(lottos.getLottosSize()).isEqualTo(3);

    }

}