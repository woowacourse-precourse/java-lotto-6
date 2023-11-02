package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoProviderTest {
    @Test
    @DisplayName("구매한 수량(1000원 단위)만큼 로또를 제공한다")
    void provideByPurchaseQuantity() {
        // given
        final List<Integer> numbers = List.of(3, 6, 8, 10, 15, 45);

        // when
        final List<Lotto> lottos = LottoProvider.provideByPurchaseQuantity(
                () -> numbers,
                5
        );

        // then
        assertAll(
                () -> assertThat(lottos).hasSize(5),
                () -> assertThat(lottos)
                        .map(Lotto::getNumbers)
                        .containsExactly(
                                numbers,
                                numbers,
                                numbers,
                                numbers,
                                numbers
                        )
        );
    }
}
