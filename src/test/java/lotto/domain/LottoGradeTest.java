package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGradeTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("번호 0개 일치 시 테스트")
    void 번호_0개_일치(boolean isMatchBonus) {
        int matchNumberCount = 0;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.NONE);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("번호 1개 일치 시 테스트")
    void 번호_1개_일치(boolean isMatchBonus) {
        int matchNumberCount = 1;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.NONE);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("번호 2개 일치 시 테스트")
    void 번호_2개_일치(boolean isMatchBonus) {
        int matchNumberCount = 2;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.NONE);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("번호 3개 일치 시 5등 테스트")
    void 번호_3개_일치_5등(boolean isMatchBonus) {
        int matchNumberCount = 3;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("번호 4개 일치 시 4등 테스트")
    void 번호_4개_일치_4등(boolean isMatchBonus) {
        int matchNumberCount = 4;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("번호 5개 일치 및 보너스 불일치 시 3등 테스트")
    void 번호_5개_일치_보너스_번호_불일치_3등() {
        int matchNumberCount = 5;
        boolean isMatchBonus = false;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.THIRD);
    }

    @Test
    @DisplayName("번호 5개 일치 및 보너스 일치 시 2등 테스트")
    void 번호_5개_일치_보너스_번호_일치_2등() {
        int matchNumberCount = 5;
        boolean isMatchBonus = true;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.SECOND);
    }

    @Test
    @DisplayName("번호 6개 일치 시 1등 테스트")
    void 번호_6개_일치_1등() {
        int matchNumberCount = 6;
        boolean isMatchBonus = false;
        LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumberCount, isMatchBonus);

        assertThat(lottoGrade).isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("총 당첨 금액 구하기 테스트")
    void 총_당첨_금액_구하기() {
        Map<LottoGrade, Integer> result = Map.of(
                LottoGrade.FIRST, 1,
                LottoGrade.SECOND, 1,
                LottoGrade.THIRD, 1,
                LottoGrade.FOURTH, 1,
                LottoGrade.FIFTH, 1
        );
        int totalPrize = LottoGrade.getTotalPrize(result);

        assertThat(totalPrize).isEqualTo(2031555000);
    }
}
