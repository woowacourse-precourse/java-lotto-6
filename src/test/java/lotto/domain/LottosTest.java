package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("불변객체를 조작하려는 경우 예외가 발생한다.")
    @Test
    void should_ThrowException_When_TryToManipulate() {
        SpecificLottoGenerator generator = new SpecificLottoGenerator(List.of(1, 2, 3, 4, 5, 6));
        Quantity totalLottery = Quantity.of(new Money(1000), 1000);
        Lottos lottos = Lottos.of(totalLottery, generator);
        assertThatThrownBy(() -> lottos.getPackOfLotteryTickets().clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("올바른 로또의 장 수를 반환한다.")
    @Test
    void should_ReturnAmountsOfLotto() {
        SpecificLottoGenerator generator = new SpecificLottoGenerator(List.of(1, 2, 3, 4, 5, 6));
        Quantity totalLottery = Quantity.of(new Money(10000), 1000);
        Lottos lottos = Lottos.of(totalLottery, generator);
        assertThat(lottos.getPackOfLotteryTickets().size()).isEqualTo(10);
    }
}