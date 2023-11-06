package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class LottosTest {

    @ParameterizedTest
    @DisplayName("로또 수량대로 로또를 생성하고 반환한다.")
    @CsvSource(value = {"5,5", "10,10", "15,15"})
    void generateLottosTest(int quantity, int expect) {
        //given
        Lottos lottos;
        lottos = new Lottos(new LottoQuantity(quantity));

        //when
        List<Lotto> lottosForTest = lottos.getMyLottos();

        //then
        Assertions.assertThat(lottosForTest.size()).isEqualTo(expect);
    }
}