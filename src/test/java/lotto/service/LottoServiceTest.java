package lotto.service;

import static lotto.Message.ErrorMessage.OBJECT_IS_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.config.WinningResultConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LottoServiceTest {
    private static List<List<Integer>> userLottoNumbers;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    @DisplayName("LottoService_초기화")
    @BeforeAll
    static void LottoService_initialize() {
        userLottoNumbers = Arrays.asList(
                Arrays.asList(3, 6, 8, 26, 44, 34),//2
                Arrays.asList(1, 2, 3, 4, 29, 30),//4
                Arrays.asList(1, 2, 3, 4, 5, 8),//5
                Arrays.asList(1, 2, 3, 4, 5, 7),//5, 보너스 볼
                Arrays.asList(1, 2, 3, 4, 5, 6)//6
        );
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @DisplayName("LottoService_null_들어왔을_때_예외_처리")
    @Test
    void LottoService_null_input() {
        assertThatThrownBy(() -> new LottoService(null, winningNumbers,bonusNumber))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining(OBJECT_IS_NULL.getMessage());
    }

    @DisplayName("LottoService_당첨_로또_번호_개수_세기_3_이상")
    @Test
    void LottoService_count_equalNumber() {
        LottoService lottoService = new LottoService(userLottoNumbers, winningNumbers, bonusNumber);
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
