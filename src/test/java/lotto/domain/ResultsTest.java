package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @Test
    @DisplayName("일치 갯수를 기준으로 당첨 통계를 추출한다")
    void getPrize() {
        // given
        Result result1 = new Result(1, false);
        Result result2 = new Result(5, false);
        Result result3 = new Result(5, true);

        List<Result> result = List.of(result1, result2, result3);
        Results results = new Results(result);

        // when
        Map<Prize, Integer> calculate = results.getPrizeResult();

        // then
        assertAll(
                () -> calculate.get(Prize.SECOND),
                () -> calculate.get(Prize.THIRD)
        );
    }
}