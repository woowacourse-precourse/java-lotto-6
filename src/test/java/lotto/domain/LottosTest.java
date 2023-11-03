package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    void 구매개수에_따른_로또를_생성한다() {
        // Given
        Amount amount = new Amount(2000);

        // When
        Lottos lottos = Lottos.generateByAmount(amount);

        // Then
        assertNotNull(lottos);
    }
}