package lotto.domain.ranking;

import static lotto.domain.constant.LottoConstant.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankingTest {

    @DisplayName("상금 정보를 갖고 있다.")
    @ParameterizedTest(name = "[{0}] : {1}원")
    @CsvSource(value = {
        "FIRST, 2000000000",
        "SECOND, 30000000",
        "THIRD, 1500000",
        "FOURTH, 50000",
        "FIFTH, 5000",
        "UNRANKED, 0"
    })
    void hasPrizeInformation(final String ranking, final int prize) {
        // given
        LottoRanking lottoRanking = LottoRanking.valueOf(ranking);

        // when
        int result = lottoRanking.getPrizeValue();

        // then
        assertThat(result).isEqualTo(prize);
    }

    @DisplayName("맞춰야 하는 개수 정보를 갖고 있다.")
    @ParameterizedTest(name = "[{0}] : {1}개")
    @CsvSource(value = {
        "FIRST, 6",
        "SECOND, 5",
        "THIRD, 5",
        "FOURTH, 4",
        "FIFTH, 3",
        "UNRANKED, 2"
    })
    void hasNumberOfMatchesInformation(final String ranking, final int numberOfMatches) {
        // given
        LottoRanking lottoRanking = LottoRanking.valueOf(ranking);

        // when
        int result = lottoRanking.getNumberOfMatches();

        // then
        assertThat(result).isEqualTo(numberOfMatches);
    }

    @DisplayName("맞춘 개수, 보너스 볼 일치 여부를 이용해 적절한 등수를 제공한다.")
    @ParameterizedTest(
        name = "[{index}] : numberOfMatches = {0}, bonusBallMatches = {1}, expected = {2}"
    )
    @CsvSource(value = {
        "6, false, FIRST",
        "5, true, SECOND", "5, false, THIRD",
        "4, true, FOURTH", "4, false, FOURTH",
        "3, true, FIFTH", "3, false, FIFTH",
        "2, true, UNRANKED", "2, false, UNRANKED",
        "1, true, UNRANKED", "1, false, UNRANKED",
        "0, true, UNRANKED", "0, false, UNRANKED",
    })
    void providesRankingByNumberOfMatchesAndBonusBallMatches(final int numberOfMatches,
                                                             final boolean bonusBallMatches,
                                                             final String expected) {
        // when
        LottoRanking ranking = LottoRanking.of(numberOfMatches, bonusBallMatches);

        // then
        assertThat(ranking.name()).isEqualTo(expected);
    }

    @DisplayName("맞춘 개수는 로또 번호 개수를 초과활 수 없다.")
    @Test
    void numberOfMatchesCannotGreaterThanLottoNumberSize() {
        // given
        int numberOfMatch = LOTTO_NUMBERS_SIZE + 1;
        boolean bonusBallMatches = false;

        // when, then
        assertThatThrownBy(() -> LottoRanking.of(numberOfMatch, bonusBallMatches))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("numberOfMatches는 6를 초과할 수 없습니다.");
    }
}