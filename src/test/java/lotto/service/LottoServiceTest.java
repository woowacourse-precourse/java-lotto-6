package lotto.service;

import lotto.domain.constant.LottoPrize;
import lotto.domain.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        NumberGenerator numberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        lottoService = new LottoService(numberGenerator);
    }

    @DisplayName("로또 번호를 성공적으로 생성한다.")
    @Test
    void generateLottos() {
        List<List<Integer>> lottos = lottoService.generateLottos("2000");

        assertThat(lottos.get(0)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottos.get(1)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 결과를 성공적으로 반환환다.")
    @Test
    void getLottoResults() {
        List<String> winningLottoInput = List.of("1", "2", "3", "4", "5", "6");
        String bonusInput = "7";

        lottoService.generateLottos("2000");
        lottoService.createWinningLotto(winningLottoInput, bonusInput);
        Map<LottoPrize, Integer> lottoResults = lottoService.getLottoResults();

        assertThat(lottoResults.get(LottoPrize.FIRST)).isEqualTo(2);
        assertThat(lottoResults.get(LottoPrize.FORTH)).isEqualTo(0);
    }

    @DisplayName("로또 수익률을 성공적으로 반환한다.")
    @Test
    void getProfitRate() {
        List<String> winningLottoInput = List.of("1", "2", "3", "41", "15", "16");
        String bonusInput = "7";

        lottoService.generateLottos("12000");
        lottoService.createWinningLotto(winningLottoInput, bonusInput);
        lottoService.getLottoResults();
        double profitRate = lottoService.getProfitRate();

        assertThat(profitRate).isEqualTo(12 * 5000 * 100 / 12000.0);
    }
}