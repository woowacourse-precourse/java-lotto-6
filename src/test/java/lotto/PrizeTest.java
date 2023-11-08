package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Prize;
import lotto.dto.LottoMatchResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {
    private static final int SIX = 6;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int THREE = 3;

    @DisplayName("로또 번호 6개가 일치하면 FIRST를 반환한다.")
    @Test
    void matchFirstPrize() {
        assertThat(Prize.valueOf(new LottoMatchResponse(SIX, false))).isEqualTo(Prize.FIRST);
        assertThat(Prize.valueOf(new LottoMatchResponse(SIX, true))).isEqualTo(Prize.FIRST);
    }

    @DisplayName("로또 번호 5개와 보너스 번호가 일치하면 SECOND를 반환한다.")
    @Test
    void matchSecondPrize() {
        assertThat(Prize.valueOf(new LottoMatchResponse(FIVE, true))).isEqualTo(Prize.SECOND);
    }

    @DisplayName("로또 번호 5개와 보너스 번호가 불일치하면 THIRD를 반환한다.")
    @Test
    void matchThirdPrize() {
        assertThat(Prize.valueOf(new LottoMatchResponse(FIVE, false))).isEqualTo(Prize.THIRD);
    }

    @DisplayName("로또 번호 4개가 일치하면 FOURTH를 반환한다.")
    @Test
    void matchFourthPrize() {
        assertThat(Prize.valueOf(new LottoMatchResponse(FOUR, false))).isEqualTo(Prize.FOURTH);
        assertThat(Prize.valueOf(new LottoMatchResponse(FOUR, true))).isEqualTo(Prize.FOURTH);
    }

    @DisplayName("로또 번호 3개가 일치하면 FIFTH를 반환한다.")
    @Test
    void matchFifthPrize() {
        assertThat(Prize.valueOf(new LottoMatchResponse(THREE, false))).isEqualTo(Prize.FIFTH);
        assertThat(Prize.valueOf(new LottoMatchResponse(THREE, true))).isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 번호 3개 미만 시 NONE를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void matchNonPrize(int matchCount) {
        assertThat(Prize.valueOf(new LottoMatchResponse(matchCount, false))).isEqualTo(Prize.NONE);
        assertThat(Prize.valueOf(new LottoMatchResponse(matchCount, true))).isEqualTo(Prize.NONE);
    }
}