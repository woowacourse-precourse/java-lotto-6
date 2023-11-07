package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.config.AppConfig;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    AppConfig appConfig = new AppConfig();
    private LottoService lottoService = appConfig.lottoService();

    @Test
    @DisplayName(value = "일치하는 번호가 없으면 0을 반환하는지 확인")
    void compareLottoByNonMatchNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12));

        assertThat(lottoService.compareLotto(lotto, inputNumbers)).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "일치하는 번호가 존재한다면 일치하는 번호의 수만큼 반환하는지 확인")
    void compareLottoByAllMatchNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoService.compareLotto(lotto, inputNumbers)).isEqualTo(6);
    }

}