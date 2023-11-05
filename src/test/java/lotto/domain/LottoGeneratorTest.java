package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

	@DisplayName("구입 금액이 로또 1장 가격보다 적으면 예외가 발생한다.")
    @Test
    void paidAffordable() {
        assertThatThrownBy(() -> new LottoGenerator(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
