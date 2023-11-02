package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoProviderTest {
    @Test
    @DisplayName("구매한 수량(1000원 단위)만큼 로또를 정렬된 상태로 제공한다")
    void provideByPurchaseQuantity() {
        // when
        final List<Lotto> lottos = LottoProvider.provideByPurchaseQuantity(
                () -> Arrays.asList(15, 8, 45, 3, 10, 6),
                5
        );

        // then
        assertAll(
                () -> assertThat(lottos).hasSize(5),
                () -> assertThat(lottos)
                        .map(Lotto::getNumbers)
                        .containsExactly(
                                List.of(3, 6, 8, 10, 15, 45),
                                List.of(3, 6, 8, 10, 15, 45),
                                List.of(3, 6, 8, 10, 15, 45),
                                List.of(3, 6, 8, 10, 15, 45),
                                List.of(3, 6, 8, 10, 15, 45)
                        )
        );
    }
}
