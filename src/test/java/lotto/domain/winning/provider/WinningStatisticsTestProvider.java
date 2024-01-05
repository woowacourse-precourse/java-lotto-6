package lotto.domain.winning.provider;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.amount.Amount;
import lotto.domain.rank.Rank;
import org.junit.jupiter.params.provider.Arguments;

public class WinningStatisticsTestProvider {

    public static Stream<Arguments> provideValuesForWinningStatisticsExceptionTest() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Rank.THREE_MATCHED
                        ),
                        new Amount(5000),
                        Map.of(
                                Rank.THREE_MATCHED, 1L
                        )
                ),

                Arguments.of(
                        List.of(
                                Rank.FOUR_MATCHED,
                                Rank.FOUR_MATCHED,
                                Rank.FOUR_MATCHED
                        ),
                        new Amount(10000),
                        Map.of(
                                Rank.FOUR_MATCHED, 3L
                        )
                ),

                Arguments.of(
                        List.of(
                                Rank.THREE_MATCHED,
                                Rank.FIVE_MATCHED
                        ),
                        new Amount(5000),
                        Map.of(
                                Rank.THREE_MATCHED, 1L,
                                Rank.FIVE_MATCHED, 1L
                        )
                )
        );
    }

    public static Stream<Arguments> provideValuesForProfitRateExceptionTest() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Rank.THREE_MATCHED
                        ),
                        new Amount(5000), 1.00
                ),

                Arguments.of(
                        List.of(
                                Rank.FOUR_MATCHED,
                                Rank.FOUR_MATCHED,
                                Rank.FOUR_MATCHED
                        ),
                        new Amount(10000), 15.00
                ),

                Arguments.of(
                        List.of(
                                Rank.THREE_MATCHED,
                                Rank.FIVE_MATCHED
                        ),
                        new Amount(5000), 301.00
                )
        );
    }
}
