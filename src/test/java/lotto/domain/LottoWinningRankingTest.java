package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoWinningRankingTest {

    LottoWinningRanking none = LottoWinningRanking.NONE;
    LottoWinningRanking fifth = LottoWinningRanking.FIFTH;
    LottoWinningRanking fourth = LottoWinningRanking.FOURTH;
    LottoWinningRanking third = LottoWinningRanking.THIRD;
    LottoWinningRanking second = LottoWinningRanking.SECOND;
    LottoWinningRanking first = LottoWinningRanking.FIRST;

    @ParameterizedTest
    @EnumSource(LottoWinningRanking.class)
    void junit5_기능(LottoWinningRanking lottoWinningRanking) {
        int matchedNumberCount = lottoWinningRanking.getMatchedNumberCount();
        assertThat(matchedNumberCount)
                    .isBetween(0, 6);
    }

    @Test
    void 로또_당첨_랭킹에_따른_로또_번호_매치_개수() {
        assertThat(none.getMatchedNumberCount()).isEqualTo(0);
        assertThat(fifth.getMatchedNumberCount()).isEqualTo(3);
        assertThat(fourth.getMatchedNumberCount()).isEqualTo(4);
        assertThat(third.getMatchedNumberCount()).isEqualTo(5);
        assertThat(second.getMatchedNumberCount()).isEqualTo(5);
        assertThat(first.getMatchedNumberCount()).isEqualTo(6);
    }

    @Test
    void 로또_당첨_랭킹에_따른_보너스_번호_필요_여부() {
        assertThat(none.getNeedsBonusNumber()).isFalse();
        assertThat(fifth.getNeedsBonusNumber()).isFalse();
        assertThat(fourth.getNeedsBonusNumber()).isFalse();
        assertThat(third.getNeedsBonusNumber()).isFalse();
        assertThat(second.getNeedsBonusNumber()).isTrue();
        assertThat(first.getNeedsBonusNumber()).isFalse();
    }

    @Test
    void 로또_당첨_랭킹에_따른_당첨_금액() {
        assertThat(none.getWinningAmount()).isEqualTo(0L);
        assertThat(fifth.getWinningAmount()).isEqualTo(5_000L);
        assertThat(fourth.getWinningAmount()).isEqualTo(50_000L);
        assertThat(third.getWinningAmount()).isEqualTo(1_500_000L);
        assertThat(second.getWinningAmount()).isEqualTo(30_000_000L);
        assertThat(first.getWinningAmount()).isEqualTo(2_000_000_000L);
    }

    @Test
    @DisplayName("enum 순서는 5등부터 1등 순서다. 그리고 enum은 하나의 인스턴스를 공유한다")
    void 로또_당첨_순서_테스트() {
        LottoWinningRanking[] expectedOrder = {
                none,
                fifth,
                fourth,
                third,
                second,
                first
        };

        LottoWinningRanking[] actualOrder = LottoWinningRanking.values();

        assertThat(expectedOrder).isEqualTo(actualOrder);
    }
}