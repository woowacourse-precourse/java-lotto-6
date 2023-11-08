package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    @DisplayName("구입 금액이 1,000원보다 적으면 예외가 발생한다")
    @Test
    void purchaseAmountLessThan1000() {
        assertThatThrownBy(() -> LottoGenerator.from(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다")
    @Test
    void purchaseAmountNotMultipleOf1000() {
        assertThatThrownBy(() -> LottoGenerator.from(1800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 생성한다")
    @Test
    void generateLotto() {
        int amount = 5000;

        List<Lotto> lottos = LottoGenerator.generateFrom(amount);

        lottos.stream().map(lotto -> assertThat(lotto.getClass()).isInstanceOf(Lotto.class));
    }

    @DisplayName("구입 금액만큼 로또를 생성한다")
    @Test
    void generateCorrectNumbersOfLottos() {
        int amount = 5000;

        List<Lotto> lottos = LottoGenerator.generateFrom(amount);

        assertThat(lottos.size()).isEqualTo(amount / 1000);
    }
}