package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class OutputLottoResultTest {

    @Test
    void 로또_추첨_결과를_알맞게_저장한다() {
        List<LottoResult> lottoResults = new ArrayList<>(List.of(
                new LottoResult(0, false),
                new LottoResult(1, false),
                new LottoResult(2, false),
                new LottoResult(3, false),
                new LottoResult(4, false),
                new LottoResult(5, false),
                new LottoResult(6, false),

                new LottoResult(0, true),
                new LottoResult(1, true),
                new LottoResult(2, true),
                new LottoResult(3, true),
                new LottoResult(4, true),
                new LottoResult(5, true),
                new LottoResult(6, true)
        ));

        OutputLottoResult outputLottoResult = new OutputLottoResult(lottoResults);
        assertThat(outputLottoResult.getMatch3()).isEqualTo(2);
        assertThat(outputLottoResult.getMatch4()).isEqualTo(2);
        assertThat(outputLottoResult.getMatch5()).isEqualTo(1);
        assertThat(outputLottoResult.getMatch5AndBonus()).isEqualTo(1);
        assertThat(outputLottoResult.getMatch6()).isEqualTo(2);
    }

}