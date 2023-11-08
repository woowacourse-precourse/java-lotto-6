package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {

    @DisplayName("로또 구입 금액을 입력하면 금액만큼 로또를 생성한다.")
    @Test
    void createLotto() throws Exception {
        // Given
        LottoBuyPrice lottoBuyPrice = new LottoBuyPrice(5000);

        // When
        List<Lotto> lotto = LottoFactory.createLotto(lottoBuyPrice);

        // Then
        assertThat(lotto).hasSize(5);
    }
}
