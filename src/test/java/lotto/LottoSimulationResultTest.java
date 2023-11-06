package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSimulationResultTest {

    @Test
    void add() {
        String answer = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 300050.00%입니다.""";

        LottoSimulationResult result = new LottoSimulationResult();
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.MATCHED_3);
        result.add(LottoMatchResult.MATCHED_5_WITH_BONUS);

        assertThat(result.toString()).isEqualTo(answer);
    }

    @Test
    void calculateReturn() {
        LottoSimulationResult result = new LottoSimulationResult();
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.UNMATCHED);
        result.add(LottoMatchResult.MATCHED_3);
        result.add(LottoMatchResult.MATCHED_3);
        result.add(LottoMatchResult.MATCHED_3);
        result.add(LottoMatchResult.MATCHED_4);
        result.add(LottoMatchResult.MATCHED_5_WITH_BONUS);

        assertThat(result.calculateReturn()).isEqualTo(3006.5);
    }
}