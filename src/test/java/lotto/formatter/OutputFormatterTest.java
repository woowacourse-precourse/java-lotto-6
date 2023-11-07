package lotto.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.ProgressMessage;
import lotto.constant.WinningGrade;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@DisplayName("출력 포맷팅 클래스에")
class OutputFormatterTest {

    private final OutputFormatter outputFormatter = new OutputFormatter();

    @DisplayName("로또 출력 형태 포맷팅 요청시 정상적인 String를 반환한다.")
    @Test
    void formatLottos() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final Lottos lottos = new Lottos(List.of(new Lotto(numbers)));

        // when
        final String result = outputFormatter.formatLottos(lottos);

        // then
        assertThat(result).contains(numbers.toString());
    }

    @DisplayName("당첨 결과 포맷팅 요청시 정상적인 String를 반환한다.")
    @Test
    void formatWinningResult() {
        // given
        final WinningGrade firstGrade = WinningGrade.FIRST_GRADE;
        final WinningResult winningResult = new WinningResult(Map.of(firstGrade, 1));

        // when
        final String result = outputFormatter.formatWinningResult(winningResult);

        // then
        assertThat(result)
                .contains(
                        String.format(
                                ProgressMessage.WINNING_RESULT.toValue(),
                                firstGrade.toMatchNum(),
                                firstGrade.toPrize(),
                                winningResult.numOfWinningGrade(firstGrade)));
    }
}
