package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("Result를 문자열로 가져온다.")
    @Test
    void getResultToString() {
        Result result = new Result();

        String output = """
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                """;

        assertThat(result.getResult()).isEqualTo(output);
    }

    @DisplayName("result의 값을 증가시킨다.")
    @Test
    void updateResultHashMap() {
        Result result = new Result();

        result.updateResult(Rank.FIRST);
        String output = """
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 1개 
                """;

        assertThat(result.getResult()).isEqualTo(output);
    }

    @DisplayName("상금을 계산하여 반환한다.")
    @Test
    void calculatePrizeByResult() {
        Result result = new Result();

        result.updateResult(Rank.FIRST);
        long prize = 2_000_000_000;

        assertThat(result.calculatePrize()).isEqualTo(prize);
    }

}