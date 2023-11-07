package lotto.domain;

import java.util.List;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoRankInfoTest {

    @DisplayName("LottoRankInfo 정적 팩토리 메소드 정상 생성 테스트")
    @Test
    void from_EqualResult_success() {

        //given
        List<LottoRank> lottoRankList = List.of(LottoRank.FOURTH, LottoRank.FIFTH);
        //when
        LottoRankInfo lottoRankInfo = LottoRankInfo.from(lottoRankList);

        //then
        assertThat(lottoRankInfo.getLottoRankInfo().size()).isEqualTo(6);
        assertThat(lottoRankInfo.getLottoRankInfo().get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(lottoRankInfo.getLottoRankInfo().get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(lottoRankInfo.getLottoRankInfo().get(LottoRank.SECOND)).isEqualTo(0);
    }





}
