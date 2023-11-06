package lotto.application.output;

import static lotto.resource.TextResourceProvider.LOTTERY_EARNING_RATE_RESULT_TEXT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.MyApplicationTest;
import lotto.domain.LotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Application] 어플리케이션의 로또 결과 출력문구에 관한 테스트")
public class Application_LotteryResultsTest extends MyApplicationTest {

    @Test
    void 각_등수를_모두_출력한다() {
        runWithValidArgument();

        assertThat(outputs())
                .filteredOn(LOTTERY_RANKING_RESULT_FORMAT::matches)
                .hasSize(LotteryRanking.values().length - 1);
    }

    @Test
    void 각_등수를_등수출력_포맷으로_출력한다() {
        runWithValidArgument();

        assertThat(outputs())
                .filteredOn(LOTTERY_RANKING_RESULT_FORMAT::matches)
                .hasSize(LotteryRanking.values().length - 1)
                .allMatch(line -> matchesRankingResultHeaderFormat(line));
    }

    @Test
    void 총_수익률을_수익률_출력_포맷으로_출력한다() {
        runWithValidArgument();

        assertThat(outputs())
                .filteredOn(LOTTERY_EARNING_RATE_RESULT_TEXT::matches)
                .hasSize(1);

    }

    private static boolean matchesRankingResultHeaderFormat(String result) {
        List<String> arguments = LOTTERY_RANKING_RESULT_FORMAT.parse(result);
        String header = arguments.get(0);

        if (LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT.matches(header)
                || LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT.matches(header)) {
            return true;
        }
        return false;
    }

    private static void runWithValidArgument() {
        run("100000", "1,2,3,4,5,6", "7");
    }

}
