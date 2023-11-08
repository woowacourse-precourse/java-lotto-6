package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class StatisticsTest {

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 내역을 알 수 있다.")
    @ParameterizedTest
    @MethodSource("winningDetailsData")
    void calculateRank(List<Lotto> lottoTicket, Map<Rank, Integer> winningDetails) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        assertThat(Statistics.calculateRank(winningLotto, lottoTicket)).isEqualTo(winningDetails);
    }

    @DisplayName("당첨 내역을 기반으로 수익률을 알 수 있다.")
    @ParameterizedTest
    @MethodSource("profitData")
    void calculateProfitRate(Map<Rank, Integer> winningDetails, int money, String profitRate) {
        assertThat(Statistics.calculateProfitRate(winningDetails, money)).isEqualTo(profitRate);
    }

    static Stream<Arguments> winningDetailsData() {
        return Stream.of(
                arguments(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 13)),
                                new Lotto(List.of(1, 2, 3, 5, 7, 12)),
                                new Lotto(List.of(1, 2, 3, 7, 8, 12)),
                                new Lotto(List.of(1, 12, 17, 23, 28, 34))),
                        new EnumMap<>(Map.of(Rank.FIRST_PLACE, 1,
                                Rank.SECOND_PLACE, 1,
                                Rank.THIRD_PLACE, 1,
                                Rank.FOURTH_PLACE, 1,
                                Rank.FIFTH_PLACE, 1,
                                Rank.LAST_PLACE, 1))));
    }

    static Stream<Arguments> profitData() {
        return Stream.of(
                arguments(new EnumMap<>(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 0,
                                Rank.FIFTH_PLACE, 1,
                                Rank.LAST_PLACE, 0))
                        , 8000, "62.5"),
                arguments(new EnumMap<>(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 1,
                                Rank.FIFTH_PLACE, 0,
                                Rank.LAST_PLACE, 0))
                        , 3000, "1,666.7"),
                arguments(new EnumMap<>(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 0,
                                Rank.FIFTH_PLACE, 1,
                                Rank.LAST_PLACE, 0))
                        , 10000, "50.0"),
                arguments(new EnumMap<>(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 0,
                                Rank.FIFTH_PLACE, 0,
                                Rank.LAST_PLACE, 1))
                        , 10000, "0.0"));
    }


}