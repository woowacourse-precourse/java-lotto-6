package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @Test
    @DisplayName("테스트 전 enum값들 생성")
    void setUp() {
        WinningResult.countLottoResult(3, false);
        WinningResult.countLottoResult(4, false);
        WinningResult.countLottoResult(5, true);
    }

    @Test
    @DisplayName("생성된 결과물을 바탕으로 등수가 맞게 카운트 됐는지 검증")
    void testCountLottoResult() {
        assertThat(WinningResult.FIFTH.getCountResult()).isEqualTo(1);
        assertThat(WinningResult.FOURTH.getCountResult()).isEqualTo(1);
        assertThat(WinningResult.SECOND.getCountResult()).isEqualTo(1);
    }

    @Test
    @DisplayName("카운트 한 등수 값으로 총 수익액 검증")
    void testCalculateTotalPrice() {
        int totalPrice = WinningResult.calculateTotalPrice();

        assertThat(totalPrice).isEqualTo(30_055_000);
    }
}
