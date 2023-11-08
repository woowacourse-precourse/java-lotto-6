package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {
    @DisplayName("구매할 수 있는 만큼 로또를 구매한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 10, 100})
    void purchaseLottos(int count) {
        Money money = new Money(count * LottoOption.LOTTO_PRICE);
        Lottos lottos = Lottos.purchaseLottos(money);

        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("size 는 가지고 있는 로또 개수만큼 반환한다.")
    @Test
    void sizeTest() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));

        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }
}