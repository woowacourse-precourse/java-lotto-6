package lotto.domain;

import lotto.domain.LottoMatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMatchTest {
    @DisplayName("matchCount가 3이고, isBonus가 false일 때 FIFTH_PLACE를 반환한다.")
    @Test
    void getLottoMatchTest() {
        // when
        LottoMatch lottoMatch = LottoMatch.getLottoMatch(3, false);

        // then
        assertThat(lottoMatch).isEqualTo(LottoMatch.FIFTH_PLACE);
    }

    @DisplayName("matchCount가 2 이하 이고, isBonus가 false일 때 NON_PLACE를 반환한다.")
    @Test
    void getLottoMatchTest2() {
        // when
        LottoMatch lottoMatch = LottoMatch.getLottoMatch(1, false);

        // then
        assertThat(lottoMatch).isEqualTo(LottoMatch.NON_PLACE);
    }

    @DisplayName("matchCount가 5이고, isBonus가 false일 때 THIRD_PLACE를 반환한다.")
    @Test
    void getLottoMatchTest3() {
        // when
        LottoMatch lottoMatch = LottoMatch.getLottoMatch(5, false);

        // then
        assertThat(lottoMatch).isEqualTo(LottoMatch.THIRD_PLACE);
    }

    @DisplayName("matchCount가 5이고, isBonus가 true일 때 SECOND_PLACE를 반환한다.")
    @Test
    void getLottoMatchTest4() {
        // when
        LottoMatch lottoMatch = LottoMatch.getLottoMatch(5, true);

        // then
        assertThat(lottoMatch).isEqualTo(LottoMatch.SECOND_PLACE);
    }
}
