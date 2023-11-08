import lotto.controller.LottoController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {
    @Test
    @DisplayName("싱글톤 생성 테스트")
    void singleTon() {
        LottoGeneratorService lottoGeneratorService_1 = LottoGeneratorServiceImpl.getInstance();
        LottoGeneratorService lottoGeneratorService_2 = LottoGeneratorServiceImpl.getInstance();
        assertThat(lottoGeneratorService_1 == lottoGeneratorService_2).isEqualTo(true);

        WinningLottoFactory winningLottoFactory_1 = WinningLottoFactoryImpl.getInstance();
        WinningLottoFactory winningLottoFactory_2 = WinningLottoFactoryImpl.getInstance();
        assertThat(winningLottoFactory_1 == winningLottoFactory_2).isEqualTo(true);

        StatisticsService statisticsService_1 = StatisticsServiceImpl.getInstance(
                new ArrayList<Lotto>(), new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7, new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                );
        StatisticsService statisticsService_2 = StatisticsServiceImpl.getInstance(
                new ArrayList<Lotto>(), new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7, new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        );
        assertThat(statisticsService_1 == statisticsService_2).isEqualTo(true);

        LottoController lottoController_1 = LottoController.getInstance();
        LottoController lottoController_2 = LottoController.getInstance();
        assertThat(lottoController_1 == lottoController_2).isEqualTo(true);

        // 싱글톤 아닌 경우 false
        BonusNumber bonusNumber_1 = new BonusNumber(7, new Lotto(List.of(1,2,3,4,5,6)));
        BonusNumber bonusNumber_2 = new BonusNumber(7, new Lotto(List.of(1,2,3,4,5,6)));
        assertThat(bonusNumber_1 == bonusNumber_2).isEqualTo(false);
    }
}
