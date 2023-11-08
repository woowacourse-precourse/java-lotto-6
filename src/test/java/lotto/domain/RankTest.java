package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    @DisplayName("1등 조건에 따라 1등이 생성되는 지 테스트")
    void firstPlaceTest() {
        //given
        Rank rank = Rank.FIRST;
        //when
        boolean result = rank.matchRank(6, false);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("2등 조건에 따라 2등이 생성되는 지 테스트")
    void secondPlaceTest() {
        //given
        Rank rank = Rank.SECOND;
        //when
        boolean result = rank.matchRank(5, true);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("3등 조건에 따라 3등이 생성되는 지 테스트")
    void thirdPlaceTest() {
        //given
        Rank rank = Rank.THIRD;
        //when
        boolean result = rank.matchRank(5, false);
        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("4등 조건에 따라 4등이 생성되는 지 테스트")
    void fourthPlaceTest() {
        //given
        Rank rank = Rank.FOURTH;
        //when
        boolean resultWithBonus = rank.matchRank(4, true);
        boolean resultWithoutBonus = rank.matchRank(4, false);
        //then
        assertThat(resultWithBonus).isTrue();
        assertThat(resultWithoutBonus).isTrue();
    }

    @Test
    @DisplayName("5등 조건에 따라 5등이 생성되는 지 테스트")
    void fifthPlaceTest() {
        //given
        Rank rank = Rank.FIFTH;
        //when
        boolean resultWithBonus = rank.matchRank(3, true);
        boolean resultWithoutBonus = rank.matchRank(3, false);
        //then
        assertThat(resultWithBonus).isTrue();
        assertThat(resultWithoutBonus).isTrue();
    }

    @Test
    @DisplayName("맞은 개수가 2개인 경우 NOTHING_TWO라는 RANK를 가지는 지 테스트")
    void nothing_twoPlaceTest() {
        //given
        Rank rank = Rank.NOTHING_TWO;
        //when
        boolean resultWithBonus = rank.matchRank(2, true);
        boolean resultWithoutBonus = rank.matchRank(2, false);
        //then
        assertThat(resultWithBonus).isTrue();
        assertThat(resultWithoutBonus).isTrue();
    }

    @Test
    @DisplayName("맞은 개수가 1개인 경우 NOTHING_ONE라는 RANK를 가지는 지 테스트")
    void nothing_onePlaceTest() {
        //given
        Rank rank = Rank.NOTHING_ONE;
        //when
        boolean resultWithBonus = rank.matchRank(1, true);
        boolean resultWithoutBonus = rank.matchRank(1, false);
        //then
        assertThat(resultWithBonus).isTrue();
        assertThat(resultWithoutBonus).isTrue();
    }

    @Test
    @DisplayName("맞은 개수가 0개인 경우 NOTHING_ZERO라는 RANK를 가지는 지 테스트")
    void nothing_zeroPlaceTest() {
        //given
        Rank rank = Rank.NOTHING_ZERO;
        //when
        boolean resultWithBonus = rank.matchRank(0, true);
        boolean resultWithoutBonus = rank.matchRank(0, false);
        //then
        assertThat(resultWithBonus).isTrue();
        assertThat(resultWithoutBonus).isTrue();
    }
}