package lotto.constant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoResultRule의")
public class LottoResultRuleTest {

    @Test
    @DisplayName("THREE_MATCH가 반환 되는가")
    void three_without_bonus_to_three_match() {
        //given
        final Integer matchCount = 3;
        final boolean hasBonus = false;

        //when
        final LottoResultRule actualLottoResultRule = LottoResultRule.matchCount(matchCount, hasBonus);

        //then
        assertThat(actualLottoResultRule).isEqualTo(LottoResultRule.THREE_MATCH);
    }

    @Test
    @DisplayName("FOUR_MATCH가 반환 되는가")
    void four_without_bonus_to_four_match() {
        //given
        final Integer matchCount = 4;
        final boolean hasBonus = false;

        //when
        final LottoResultRule actualLottoResultRule = LottoResultRule.matchCount(matchCount, hasBonus);

        //then
        assertThat(actualLottoResultRule).isEqualTo(LottoResultRule.FOUR_MATCH);
    }

    @Test
    @DisplayName("FIVE_MATCH가 반환 되는가")
    void five_without_bonus_to_five_match() {
        //given
        final Integer matchCount = 5;
        final boolean hasBonus = false;

        //when
        final LottoResultRule actualLottoResultRule = LottoResultRule.matchCount(matchCount, hasBonus);

        //then
        assertThat(actualLottoResultRule).isEqualTo(LottoResultRule.FIVE_MATCH);
    }

    @Test
    @DisplayName("FIVE_MATCH_WITH_BONUS가 반환 되는가")
    void five_with_bonus_to_five_match_with_bonus() {
        //given
        final Integer matchCount = 5;
        final boolean hasBonus = true;

        //when
        final LottoResultRule actualLottoResultRule = LottoResultRule.matchCount(matchCount, hasBonus);

        //then
        assertThat(actualLottoResultRule).isEqualTo(LottoResultRule.FIVE_MATCH_WITH_BONUS);
    }

    @Test
    @DisplayName("SIX_MATCH가 반환 되는가")
    void six_without_bonus_to_six_match() {
        //given
        final Integer matchCount = 6;
        final boolean hasBonus = false;

        //when
        final LottoResultRule actualLottoResultRule = LottoResultRule.matchCount(matchCount, hasBonus);

        //then
        assertThat(actualLottoResultRule).isEqualTo(LottoResultRule.SIX_MATCH);
    }

    @ParameterizedTest
    @DisplayName("NONE가 반환 되는가")
    @ValueSource(ints = {0, 1, 2})
    void without_bonus_to_none(Integer input) {
        //given
        final boolean hasBonus = false;

        //when
        final LottoResultRule actualLottoResultRule = LottoResultRule.matchCount(input, hasBonus);

        //then
        assertThat(actualLottoResultRule).isEqualTo(LottoResultRule.NONE);
    }
}
