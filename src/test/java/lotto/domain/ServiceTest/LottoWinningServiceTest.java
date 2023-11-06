package lotto.domain.ServiceTest;

import lotto.domain.Model.Lotto;
import lotto.domain.Model.LottoContainer;
import lotto.domain.Service.LottoWinningService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoWinningServiceTest {

    @DisplayName("고정된 로또 숫자에 대한 결과를 검증한다.")
    @Test
    void calculateWinningsFromFixedLottoContainer() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoContainer lottoContainer = new LottoContainer();

        lottoContainer.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoContainer.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoContainer.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottoContainer.add(new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)));
        lottoContainer.add(new Lotto(Arrays.asList(14, 15, 16, 17, 18, 19)));

        LottoWinningService lottoWinningService = new LottoWinningService();
        Map<String, Integer> winnings
                = lottoWinningService.calculateWinnings(lottoContainer, winningNumbers, bonusNumber);

        assertEquals(1, winnings.getOrDefault("6개 일치", 0));
        assertEquals(1, winnings.getOrDefault("5개 일치, 보너스 볼 일치", 0));
        assertEquals(1, winnings.getOrDefault("5개 일치", 0));
        assertEquals(1, winnings.getOrDefault("3개 일치", 0));
        assertEquals(0, winnings.getOrDefault("", 0));


    }
}
