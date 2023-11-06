package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StatisticsOfficeTest {

    @DisplayName("당첨 번호 추첨 시 로또 번호 6개와 로또 번호에 해당하는 보너스 번호 1개를 뽑는다.")
    @Test
    void registerWinningLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = Integer.valueOf(7);
        assertThat(StatisticsOffice.registerWinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(StatisticsOffice.class);
    }

    @DisplayName("당첨 로또 번호 6개와 보너스 번호가 중복될 시 예외가 발생한다.")
    @Test
    void validateDuplicate() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = Integer.valueOf(3);
        assertThatThrownBy(() -> StatisticsOffice.registerWinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }


    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 내역을 알 수 있다.")
    @ParameterizedTest
    @MethodSource("rankStatusData")
    void convertToRank(List<Lotto> lottoTicket, Map<Rank, Integer> rankStatus) {
        StatisticsOffice statisticsOffice = StatisticsOffice.registerWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(statisticsOffice.convertToRank(lottoTicket)).isEqualTo(rankStatus);
    }

    @DisplayName("당첨 내역을 기반으로 수익률을 알 수 있다.")
    @ParameterizedTest
    @MethodSource("profitData")
    void calculateProfitRate(Map<Rank, Integer> rankStatus, int money, String profitRate) {
        assertThat(StatisticsOffice.calculateProfitRate(rankStatus, money)).isEqualTo(profitRate);
    }

    static Stream<Arguments> rankStatusData() {
        return Stream.of(
                arguments(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 13)),
                                new Lotto(List.of(1, 2, 3, 5, 7, 12)),
                                new Lotto(List.of(1, 2, 3, 7, 8, 12)),
                                new Lotto(List.of(1, 12, 17, 23, 28, 34))),
                        Map.of(Rank.FIRST_PLACE, 1,
                                Rank.SECOND_PLACE, 1,
                                Rank.THIRD_PLACE, 1,
                                Rank.FOURTH_PLACE, 1,
                                Rank.FIFTH_PLACE, 1,
                                Rank.LAST_PLACE, 1)));
    }

    static Stream<Arguments> profitData() {
        return Stream.of(
                arguments(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 0,
                                Rank.FIFTH_PLACE, 1,
                                Rank.LAST_PLACE, 0)
                        , 8000, "62.5"),
                arguments(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 1,
                                Rank.FIFTH_PLACE, 0,
                                Rank.LAST_PLACE, 0)
                        , 3000, "1666.7"),
                arguments(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 0,
                                Rank.FIFTH_PLACE, 1,
                                Rank.LAST_PLACE, 0)
                        , 10000, "50.0"),
                arguments(Map.of(Rank.FIRST_PLACE, 0,
                                Rank.SECOND_PLACE, 0,
                                Rank.THIRD_PLACE, 0,
                                Rank.FOURTH_PLACE, 0,
                                Rank.FIFTH_PLACE, 0,
                                Rank.LAST_PLACE, 1)
                        , 10000, "0.0"));
    }


}