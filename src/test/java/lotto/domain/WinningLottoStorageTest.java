package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class WinningLottoStorageTest {

    static Stream<Arguments> storeAndGetParameter() {
        return Stream.of(
                Arguments.of("3개 일치, 당첨 0개", Rank.CORRECT_THREE, 0, 0),
                Arguments.of("3개 일치, 당첨 1개", Rank.CORRECT_THREE, 1, 1),
                Arguments.of("4개 일치 당첨 2개", Rank.CORRECT_FOUR, 2, 2),
                Arguments.of("5개 일치 당첨 3개", Rank.CORRECT_FIVE, 3, 3),
                Arguments.of("5개 + 보너스 일치 당첨 4개", Rank.CORRECT_FIVE_BONUS, 4, 4),
                Arguments.of("6개 일치 당첨 5개", Rank.CORRECT_SIX, 5, 5)
        );
    }

    static Stream<Arguments> rateOfReturnParameter() {
        return Stream.of(
                Arguments.of("당첨 여부 없음", List.of(), 8000, 0.0),
                Arguments.of("3개 일치, 당첨 1개", List.of(Rank.CORRECT_THREE), 8000, 62.5),
                Arguments.of("3개 일치 당첨 1개, 4개 일치 당첨 1개", List.of(Rank.CORRECT_THREE, Rank.CORRECT_FOUR), 10000, 550.0),
                Arguments.of("3개 일치 당첨 1개, 5개 + 보너스 일치 당첨 1개", List.of(Rank.CORRECT_THREE, Rank.CORRECT_FIVE_BONUS), 10000, 300050.0),
                Arguments.of("6개 일치 당첨 1개", List.of(Rank.CORRECT_SIX), 100000, 2000000.0)
        );
    }

    @DisplayName("당첨된 로또를 저장하고 반환한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("storeAndGetParameter")
    void storeAndGetRank(String testName, Rank rank, int plusCount, int resultCount) {
        // given
        WinningLottoStorage winningLottoStorage = new WinningLottoStorage();

        // when
        IntStream.range(0, plusCount).mapToObj(i -> rank).forEach(winningLottoStorage::store);

        // then
        assertThat(winningLottoStorage.getRank(rank)).isEqualTo(resultCount);
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("rateOfReturnParameter")
    void getRateOfReturn(String testName, List<Rank> correctRanks, int purchasePrice, double rateOfReturnResult) {
        // given
        WinningLottoStorage winningLottoStorage = new WinningLottoStorage();
        correctRanks.forEach(winningLottoStorage::store);

        // when
        double rateOfReturn = winningLottoStorage.getRateOfReturn(purchasePrice);

        // then
        assertThat(rateOfReturn).isEqualTo(rateOfReturnResult);
    }
}