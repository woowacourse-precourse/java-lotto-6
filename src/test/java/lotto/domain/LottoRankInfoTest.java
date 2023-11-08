package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankInfoTest {

    @DisplayName("로또 당첨 기준 정보를 5등부터 1등순으로 정렬한 리스트로 얻는다.")
    @Test
    void getRankInfoByList() {
        List<LottoRankInfo> rankInfos = LottoRankInfo.getRankInfoByList();

        assertThat(rankInfos.get(0)).isEqualTo(LottoRankInfo.FIFTH);
        assertThat(rankInfos.get(1)).isEqualTo(LottoRankInfo.FOURTH);
        assertThat(rankInfos.get(2)).isEqualTo(LottoRankInfo.THIRD);
        assertThat(rankInfos.get(3)).isEqualTo(LottoRankInfo.SECOND);
        assertThat(rankInfos.get(4)).isEqualTo(LottoRankInfo.FIRST);
    }

    @DisplayName("당첨된 번호 개수와 보너스 번호 당첨 여부에 따라 당첨 정보를 얻는다.")
    @Test
    void getLottoRankInfo() {
        LottoRankInfo rankFifth = LottoRankInfo.getLottoRankInfo(3, false);
        LottoRankInfo rankFourth = LottoRankInfo.getLottoRankInfo(4, false);
        LottoRankInfo rankThird = LottoRankInfo.getLottoRankInfo(5, false);
        LottoRankInfo rankSecond = LottoRankInfo.getLottoRankInfo(5, true);
        LottoRankInfo rankFirst = LottoRankInfo.getLottoRankInfo(6, false);

        assertThat(rankFifth).isEqualTo(LottoRankInfo.FIFTH);
        assertThat(rankFourth).isEqualTo(LottoRankInfo.FOURTH);
        assertThat(rankThird).isEqualTo(LottoRankInfo.THIRD);
        assertThat(rankSecond).isEqualTo(LottoRankInfo.SECOND);
        assertThat(rankFirst).isEqualTo(LottoRankInfo.FIRST);
    }

    @DisplayName("당첨된 등수에 해당하는 로또 개수에 맞는 총 당첨 금액을 계산한다.")
    @Test
    void calculateTotalPrize() {
        long totalPrize1 = LottoRankInfo.FIFTH.calculateTotalPrize(10);
        long totalPrize2 = LottoRankInfo.THIRD.calculateTotalPrize(5);
        assertThat(totalPrize1).isEqualTo(50_000);
        assertThat(totalPrize2).isEqualTo(7_500_000);
    }
}