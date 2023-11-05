package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MatchNumberTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByMatchCountAndBonus_3개일치시_FIFTH반환(boolean isBonusMatch) {
        // given
        int count = 3;
        // when
        MatchNumber matchNumber = MatchNumber.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(matchNumber).isEqualTo(MatchNumber.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByMatchCountAndBonus_4개일치시_FOURTH반환(boolean isBonusMatch) {
        // given
        int count = 4;
        // when
        MatchNumber matchNumber = MatchNumber.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(matchNumber).isEqualTo(MatchNumber.FOURTH);
    }

    @Test()
    void findByMatchCountAndBonus_5개일치_보너스불일치시_THIRD반환() {
        // given
        int count = 5;
        boolean isBonusMatch = false;
        // when
        MatchNumber matchNumber = MatchNumber.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(matchNumber).isEqualTo(MatchNumber.THIRD);
    }

    @Test()
    void findByMatchCountAndBonus_5개일치_보너스일치시_SECOND반환() {
        // given
        int count = 5;
        boolean isBonusMatch = true;
        // when
        MatchNumber matchNumber = MatchNumber.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(matchNumber).isEqualTo(MatchNumber.SECOND);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByMatchCountAndBonus_6개일치시_FIRST반환(boolean isBonusMatch) {
        // given
        int count = 6;
        // when
        MatchNumber matchNumber = MatchNumber.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(matchNumber).isEqualTo(MatchNumber.FIRST);
    }

    @Test
    void findByMatchCountAndBonus_일치하는_등수_못찾으면_예외반환() {
        assertThatThrownBy(() -> MatchNumber.findByMatchCountAndBonus(7, false))
                .isInstanceOf(IllegalStateException.class);
    }

}