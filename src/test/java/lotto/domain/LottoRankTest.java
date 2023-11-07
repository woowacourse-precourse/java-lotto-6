package lotto.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("올바르게 당첨 등수 메시지 생성 - (Second)")
    @Test
    void getLottoRankMessageOfSecondRank() {
        assertThat(LottoRank.SECOND.getLottoRankMessage(2))
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개");
    }

    @DisplayName("올바르게 당첨 등수 메시지 생성 - (First)")
    @Test
    void getLottoRankMessageOfFirstRank() {
        assertThat(LottoRank.FIRST.getLottoRankMessage(3))
                .contains("6개 일치 (2,000,000,000원) - 3개");
    }

    @DisplayName("MISS일 경우 등수 메시지 빈값으로 반환")
    @Test
    void getLottoRankMessageOfMiss() {
        assertThat(LottoRank.MISS.getLottoRankMessage(3))
                .isBlank();
    }

    @DisplayName("보너스 번호와 당첨 번호가 다섯 개 일치할 경우 Second 반환")
    @Test
    void shouldGetSecondLottoRank() {
        assertThat(LottoRank.getLottoRank(5, true))
                .isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("보너스 번호가 일치하지 않고 당첨 번호가 다섯 개 일치할 경우 Third 반환")
    @Test
    void shouldGetThirdLottoRank() {
        assertThat(LottoRank.getLottoRank(5, false))
                .isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("당첨 금액의 합을 올바르게 계산")
    @Test
    void calculateTotalWinPrice() {
        assertThat(LottoRank.FIFTH.getTotalWinPrice(2))
                .isEqualTo(10_000);
    }
}