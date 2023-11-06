package lotto.model;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 등수_확인() {
        LottoResult lottoResult = new LottoResult(0);

        lottoResult.checkResult(List.of(6, 6, 5, 5, 4), List.of(false, true, true, false, true));

        assertThat(lottoResult.getFirst()).isEqualTo(2);
        assertThat(lottoResult.getSecond()).isEqualTo(1);
        assertThat(lottoResult.getThird()).isEqualTo(1);
        assertThat(lottoResult.getFourth()).isEqualTo(1);
        assertThat(lottoResult.getFifth()).isEqualTo(0);
    }
}