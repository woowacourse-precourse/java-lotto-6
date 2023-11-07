package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDataTest {
    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 6개 일치 -> 1등 당첨")
    @Test
    void checkSizMatch() {
        assertThat(LottoData.getLottoDataType(6, false))
                .isEqualTo(LottoData.FIRST_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 5개 일치, 보너스 일치 -> 2등 당첨")
    @Test
    void checkFiveMatchWithBonus() {
        assertThat(LottoData.getLottoDataType(5, true))
                .isEqualTo(LottoData.SECOND_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 5개 일치 -> 3등 당첨")
    @Test
    void checkFiveMatch() {
        assertThat(LottoData.getLottoDataType(5, false))
                .isEqualTo(LottoData.THIRD_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 4개 일치, 보너스 일치 -> 4등 당첨")
    @Test
    void checkFourMatchWithBonus() {
        assertThat(LottoData.getLottoDataType(4, false))
                .isEqualTo(LottoData.FOURTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 4개 일치 -> 4등 당첨")
    @Test
    void checkFourMatch() {
        assertThat(LottoData.getLottoDataType(4, true))
                .isNotEqualTo(LottoData.FOURTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 3개 일치, 보너스 일치 -> 5등 당첨")
    @Test
    void checkThreeMatchWithBonus() {
        assertThat(LottoData.getLottoDataType(3, false))
                .isEqualTo(LottoData.FIFTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 3개 일치 -> 5등 당첨")
    @Test
    void checkThreeMatch() {
        assertThat(LottoData.getLottoDataType(3, true))
                .isNotEqualTo(LottoData.FIFTH_PRIZE);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 2개 일치, 보너스 일치 -> 낙첨")
    @Test
    void checkTwoMatchWithBonus() {
        assertThat(LottoData.getLottoDataType(2, true))
                .isEqualTo(LottoData.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 2개 일치 -> 낙첨")
    @Test
    void checkTwoMatch() {
        assertThat(LottoData.getLottoDataType(2, false))
                .isEqualTo(LottoData.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 1개 일치, 보너스 일치 -> 낙첨")
    @Test
    void checkOneMatchWithBonus() {
        assertThat(LottoData.getLottoDataType(1, true))
                .isEqualTo(LottoData.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 1개 일치 -> 낙첨")
    @Test
    void checkOneMatch() {
        assertThat(LottoData.getLottoDataType(1, false))
                .isEqualTo(LottoData.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 0개 일치, 보너스 일치 -> 낙첨")
    @Test
    void checkNoneMatchWithBonus() {
        assertThat(LottoData.getLottoDataType(0, true))
                .isEqualTo(LottoData.BLANK);
    }

    @DisplayName("당첨 번호 개수와 보너스 당첨 여부에 따른 등수 - 0개 일치 -> 낙첨")
    @Test
    void checkNoneMatch() {
        assertThat(LottoData.getLottoDataType(0, false))
                .isEqualTo(LottoData.BLANK);
    }
}