package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();

    }

    @DisplayName("수익률을 계산하여 반환한다.")
    @Test
    void getRoundedReturn() {
        // given
        double userPurchaseAmount = 8000;

        // when
        double roundedReturn = lottoResult.getRoundedReturn(userPurchaseAmount);

        // then
        assertThat(roundedReturn).isEqualTo(0);

    }

}