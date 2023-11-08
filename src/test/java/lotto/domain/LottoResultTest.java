package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("로또 결과에 맞는 당첨 개수를 추가한다.")
    @Test
    void addMatchingCount() {
        LottoResult lottoResult = new LottoResult();
        //3개 일치 - 1개, 4개 일치 - 1개, 5개 일치 - 1개, 5개 일치 + 보너스 볼 - 0개, 6개 일치 - 0개
        lottoResult.addMatchingCount(3, false);
        lottoResult.addMatchingCount(4, false);
        lottoResult.addMatchingCount(5, false);
        assertThat(lottoResult.getThreeMatchCount()).isEqualTo(1);
        assertThat(lottoResult.getFourMatchCount()).isEqualTo(1);
        assertThat(lottoResult.getFiveMatchCount()).isEqualTo(1);
        assertThat(lottoResult.getFiveMatchWithBonusCount()).isEqualTo(0);
        assertThat(lottoResult.getSixMatchCount()).isEqualTo(0);

        //3개 일치 - 1개, 4개 일치 - 1개, 5개 일치 - 1개, 5개 일치 + 보너스 볼 - 1개, 6개 일치 - 1개
        lottoResult.addMatchingCount(5, true);
        lottoResult.addMatchingCount(6, false);
        assertThat(lottoResult.getThreeMatchCount()).isEqualTo(1);
        assertThat(lottoResult.getFourMatchCount()).isEqualTo(1);
        assertThat(lottoResult.getFiveMatchCount()).isEqualTo(1);
        assertThat(lottoResult.getFiveMatchWithBonusCount()).isEqualTo(1);
        assertThat(lottoResult.getSixMatchCount()).isEqualTo(1);
    }


}