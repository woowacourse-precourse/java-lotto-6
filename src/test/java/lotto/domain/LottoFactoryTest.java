package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    void 갯수에_맞는_로또_묶음을_생성한다() {
        LottoFactory factory = new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6));
        int size = 5;

        Lottos createdLottos = factory.createLottos(size);

        assertEquals(size, createdLottos.getLottos().size());
    }

    @Test
    void 갯수로_0이_들어오면_예외를_반환한다() {
        LottoFactory factory = new LottoFactory(() -> List.of(1, 2, 3, 4, 5, 6));
        int size = 0;

        assertThatThrownBy(() -> factory.createLottos(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }
}