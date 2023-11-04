package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class LottoResultsTest {
    @DisplayName("[Success] 각 로또의 결과와 LottoRank의 메시지를 조합해 통계 결과를 리턴한다.")
    @Test
    void returnExactStats() {
        List<LottoResult> lottoResults = List.of(
                LottoResult.create(6, false),
                LottoResult.create(5, true),
                LottoResult.create(5, false));

        assertThat(new LottoResults(lottoResults).toString())
                .isEqualTo(String.join("\n","",
                                "3개 일치 (5,000원) - 0개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 1개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 1개"));
    }
}
