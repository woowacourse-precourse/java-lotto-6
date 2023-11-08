package lotto.state;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WinningStatisticsStateTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            62.5-62.5%
            10000.12-10,000.1%
            10000.05-10,000.1%
            10000.99-10,001.0%
            """, delimiter = '-')
    void 수익률이_정상적으로_출력됩니다(final double input, final String answer) {
        final var winningStatisticsState = new WinningStatisticsState(input, List.of());

        assertThat(winningStatisticsState.getProfitResult()).isEqualTo(answer);
    }

}
