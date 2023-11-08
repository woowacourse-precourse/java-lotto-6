package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankTest {
    @DisplayName("일치하는 숫자 개수가 3보다 작으면서 보너스 숫자가 있는 경우 Rank.NONE을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0, -1})
    void getRankByMatchNumberLessThan3AndBonusNumber(int number) {
        //given
        final int matchNumber = number;
        final boolean hasBonusNumber = true;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBonusNumber);

        //then
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("일치하는 숫자 개수가 3보다 작으면서 보너스 숫자가 없는 경우 Rank.NONE을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0, -1})
    void getRankByMatchNumberLessThan3AndNoBonusNumber(int number) {
        //given
        final int matchNumber = number;
        final boolean hasBonusNumber = false;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBonusNumber);

        //then
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("일치하는 숫자 개수가 3인 경우 Rank.FIFTH_PLACE를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getRankByMatchNumber3(boolean trueOrFalse) {
        //given
        final int matchNumber = 3;
        final boolean hasBooleanNumber = trueOrFalse;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBooleanNumber);

        //then
        assertThat(rank).isEqualTo(Rank.FIFTH_PLACE);
    }

    @DisplayName("일치하는 숫자 개수가 4인 경우 Rank.FOURTH_PLACE를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getRankByMatchNumber4(boolean trueOrFalse) {
        //given
        final int matchNumber = 4;
        final boolean hasBooleanNumber = trueOrFalse;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBooleanNumber);

        //then
        assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
    }

    @DisplayName("일치하는 숫자 개수가 5면서 보너스 숫자가 없는 경우 Rank.THIRD_PLACE를 반환한다.")
    @Test
    void getRankByMatchNumber5AndNoBonusNumber() {
        //given
        final int matchNumber = 5;
        final boolean hasBooleanNumber = false;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBooleanNumber);

        //then
        assertThat(rank).isEqualTo(Rank.THIRD_PLACE);
    }

    @DisplayName("일치하는 숫자 개수가 5면서 보너스 숫자가 있는 경우 Rank.SECOND_PLACE를 반환한다.")
    @Test
    void getRankByMatchNumber5AndBonusNumber() {
        //given
        final int matchNumber = 5;
        final boolean hasBooleanNumber = true;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBooleanNumber);

        //then
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @DisplayName("일치하는 숫자 개수가 6인 경우 Rank.FIRST_PLACE를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getRankByMatchNumber6(boolean trueOrFalse) {
        //given
        final int matchNumber = 6;
        final boolean hasBooleanNumber = trueOrFalse;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBooleanNumber);

        //then
        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @DisplayName("일치하는 숫자 개수가 6보다 크면서 보너스 숫자가 있는 경우 Rank.NONE을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10})
    void getRankByMatchNumberMoreThan6AndBonusNumber(int number) {
        //given
        final int matchNumber = number;
        final boolean hasBonusNumber = true;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBonusNumber);

        //then
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("일치하는 숫자 개수가 6보다 크면서 보너스 숫자가 없는 경우 Rank.NONE을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10})
    void getRankByMatchNumberMoreThan6AndNoBonusNumber(int number) {
        //given
        final int matchNumber = number;
        final boolean hasBonusNumber = false;

        //when
        Rank rank = Rank.getRank(matchNumber, hasBonusNumber);

        //then
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
