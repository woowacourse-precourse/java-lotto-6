package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoStatus;
import lotto.service.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("각 상태별 갯수가 올바르게 매핑되었는지 확인")
    void getLottoResultDto() {
        List<LottoStatus> lottoResults = Arrays.asList(
                LottoStatus.FIRST, LottoStatus.SECOND, LottoStatus.SECOND, LottoStatus.THIRD, LottoStatus.SIXTH
        );
        LottoResult lottoResult = new LottoResult(lottoResults);
        LottoResultDto lottoResultDto = lottoResult.getLottoResultDto();

        Map<LottoStatus, Integer> lottoStatusCounts = lottoResultDto.lottoStatusCounts();

        assertThat(lottoStatusCounts.get(LottoStatus.FIRST)).isEqualTo(1);
        assertThat(lottoStatusCounts.get(LottoStatus.SECOND)).isEqualTo(2);
        assertThat(lottoStatusCounts.get(LottoStatus.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률이 제대로 계산되는지 확인한다")
    void calculateProfitRate() {
        List<LottoStatus> lottoResults = Arrays.asList(
                LottoStatus.SIXTH, LottoStatus.SIXTH, LottoStatus.SIXTH, LottoStatus.SIXTH, LottoStatus.SIXTH,
                LottoStatus.SIXTH, LottoStatus.SIXTH, LottoStatus.FIFTH
        );
        LottoResult lottoResult = new LottoResult(lottoResults);

        assertThat(lottoResult.caculateProfitRate()).isEqualTo(62.5);
    }

}
