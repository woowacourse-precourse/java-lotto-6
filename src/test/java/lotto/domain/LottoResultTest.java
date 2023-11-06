package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class LottoResultTest {

    @DisplayName("로또 결과생성 확인")
    @Test
    void lottoResultTest() {
        //given
        List<LottoRank> lottoRank = new ArrayList<>();
        lottoRank.add(LottoRank.NO_RANK);
        lottoRank.add(LottoRank.FIRST_RANK);
        lottoRank.add(LottoRank.FIRST_RANK);
        lottoRank.add(LottoRank.FIRST_RANK);

        //when
        LottoResult lottoResult = new LottoResult(lottoRank);

        //then
        Assertions.assertThat(lottoResult.getLOTTO_RESULT().get(LottoRank.FIRST_RANK)).isEqualTo(3);
        Assertions.assertThat(lottoResult.getLOTTO_RESULT().get(LottoRank.NO_RANK)).isEqualTo(1);
    }
}