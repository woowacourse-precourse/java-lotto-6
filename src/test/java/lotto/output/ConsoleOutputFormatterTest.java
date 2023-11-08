package lotto.output;

import lotto.domain.Rank;
import lotto.domain.WinningInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputFormatterTest {
    private static ConsoleOutputFormatter consoleOutputFormatter = new ConsoleOutputFormatter();

    @DisplayName("\"개를 구매했습니다.\" 형식으로 포매팅한다.")
    @Test
    void formatNumberOfLottos() {
        //given
        int numberOfLottos = 5;

        //when
        String formattedMessage = consoleOutputFormatter.formatNumberOfLottos(numberOfLottos);

        //then
        assertThat(formattedMessage)
                .isEqualTo(numberOfLottos + "개를 구매했습니다.");
    }

    @DisplayName("수익률, 당첨 개수, 당첨금을 포함해서 포매팅한다.")
    @Test
    void formatWinningInformation() {
        //given
        List<Rank> ranks = List.of(
                Rank.LOSER,
                Rank.FIFTH,
                Rank.FIFTH,
                Rank.FIRST,
                Rank.SECOND
        );
        WinningInformation winningInformation = WinningInformation.of(ranks);

        //when
        String formattedMessage = consoleOutputFormatter.formatWinningInformation(winningInformation);

        //then
        assertThat(formattedMessage)
                .isEqualTo("당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - 2개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                        "6개 일치 (2,000,000,000원) - 1개\n" +
                        "총 수익률은 40,600,200.0%입니다.");
    }

    @DisplayName("\"[ERROR] \" 형식으로 포매팅한다.")
    @Test
    void formatError() {
        //given
        String errorMessage = "error message";

        //when
        String formattedMessage = consoleOutputFormatter.formatError(errorMessage);

        //then
        assertThat(formattedMessage)
                .isEqualTo("[ERROR] " + errorMessage);
    }
}