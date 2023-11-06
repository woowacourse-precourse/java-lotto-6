package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {

    @Test
    @DisplayName("로또 수량대로 로또를 생성하고 반환한다.")
    void generateLottosTest() {
        //given
        Lottos lottos;
        lottos = new Lottos(new LottoQuantity(5));

        //when
        List<Lotto> lottosForTest = lottos.getMyLottos();

        //then
        Assertions.assertThat(lottosForTest.size()).isEqualTo(5);
    }

}
