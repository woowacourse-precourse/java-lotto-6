package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import lotto.config.WinningResultConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LottoServiceTest {
    @DisplayName("LottoService_당첨_로또_번호_개수_세기_3_이상")
    @Test
    public void LottoService_count_equalNumber() {
        List<List<Integer>> userLottoNumbers = Arrays.asList(
                Arrays.asList(3, 6, 8, 26, 44, 34),//2
                Arrays.asList(1, 2, 3, 4, 29, 30),//4
                Arrays.asList(1, 2, 3, 4, 5, 8),//5
                Arrays.asList(1, 2, 3, 4, 5, 7),//5, 보너스 볼
                Arrays.asList(1, 2, 3, 4, 5, 6)//6
        );
        List<Integer> WinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoService lottoService = new LottoService(userLottoNumbers, WinningNumbers, bonusNumber);
        Map<WinningResultConfig, Integer> lottoResults = lottoService.findWinningResult();

        assertAll(
                () -> assertThat(lottoResults.get(WinningResultConfig.THREE)).isEqualTo(0),
                () -> assertThat(lottoResults.get(WinningResultConfig.FOUR)).isEqualTo(1),
                () -> assertThat(lottoResults.get(WinningResultConfig.FIVE)).isEqualTo(1),
                () -> assertThat(lottoResults.get(WinningResultConfig.FIVE_AND_BONUS)).isEqualTo(1),
                () -> assertThat(lottoResults.get(WinningResultConfig.FIVE_AND_BONUS)).isEqualTo(1)
        );
    }
}
