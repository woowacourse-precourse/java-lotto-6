package lotto.domain;

import java.util.stream.Stream;
import lotto.domain.lotto.Lottos;
import lotto.utils.constant.BuyPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @ParameterizedTest
    @MethodSource("로또들을_생성한다_파라미터")
    void 로또들을_생성한다(BuyPrice buyPrice) {
        // given
        Lottos lottos = new Lottos(buyPrice);

        // then
        Assertions.assertThat(lottos.getCount()).isEqualTo(buyPrice.getBuyCount());
    }

    public static Stream<Arguments> 로또들을_생성한다_파라미터() {
        return Stream.of(
                Arguments.of(new BuyPrice("1000")),
                Arguments.of(new BuyPrice("3000"))
        );
    }

}