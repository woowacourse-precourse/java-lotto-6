package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.dto.LottoPlayInfo;
import lotto.domain.dto.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultServiceTest {

    @Test
    @DisplayName("로또 결과 서비스를 통한 로또 결과 생성 테스트")
    public void testGetLottoResult() {
        // 준비
        LottoResultService lottoResultService = new LottoResultService();

        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        );

        LottoPlayInfo drawnInfo = new LottoPlayInfo(
            Arrays.asList(1, 2, 3, 4, 5, 6),
            7,
            3000
        );

        LottoResult result = lottoResultService.getLottoResult(lottos, drawnInfo);

        assertThat(result.matchedCounts()).containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD);
        assertThat(result.roi()).isEqualTo(677166.7);
    }
}
