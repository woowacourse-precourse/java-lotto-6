package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {

    private LottoBuyer lottoBuyer;

    @BeforeEach
    void setUp() {
        lottoBuyer = new LottoBuyer();
    }

    @Test
    @DisplayName("구입 수량 만큼 로또를 구입한다.")
    void purchaseLottos_AsMuchAsLottoCount() {
        // Given
        final int lottoCount = 3;

        // When
        List<Lotto> result = lottoBuyer.purchaseLottos(lottoCount);

        // Then
        assertThat(result)
                .isNotEmpty()
                .hasSize(lottoCount);
    }

}