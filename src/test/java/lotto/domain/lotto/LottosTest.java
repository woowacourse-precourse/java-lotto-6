package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("Lottos에 하나 이상의 Lotto가 없으면 예외 발생")
    @Test
    public void shouldThrowExceptionWhenGivenEmptyLottos() {
        // given
        List<Lotto> lottoList1 = null;
        List<Lotto> lottosList2 = new ArrayList<>();

        // when
        // then
        assertThatThrownBy(() -> Lottos.from(lottoList1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Lottos.from(lottosList2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}