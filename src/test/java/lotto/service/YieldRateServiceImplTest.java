package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Amount;
import lotto.domain.LottoCollector;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldRateServiceImplTest {

    WinningNumber winningNumber;
    YieldRateService yieldRateService;
    LottoPublishService lottoPublishService;

    @BeforeEach
    void init() {
        yieldRateService = new YieldRateServiceImpl();
        winningNumber = new WinningNumber();
        lottoPublishService = new LottoPublishServiceImpl();
    }

    @Test
    @DisplayName("수익률 구하기")
    void getYieldRate() {
        // Given
        winningNumber.createWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningNumber.creatBonusNumber(10);
        lottoPublishService.publish(1000);

        List<Lotto> publishedLottos = new ArrayList<>(List.of(
                new Lotto(Arrays.asList(1, 2, 3, 34, 35, 26)),
                new Lotto(Arrays.asList(1,5,45,43,32,26)),
                new Lotto(Arrays.asList(15,23,43,41,35,24))
        ));


        // When
        winningNumber.checkMatchWinning(publishedLottos);
        String yieldRate = yieldRateService.calculateYieldRate();

        // Then
        Assertions.assertThat(yieldRate).isEqualTo("500.0");

    }
}