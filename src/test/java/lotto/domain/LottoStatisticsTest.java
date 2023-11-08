package lotto.domain;

import java.util.List;
import lotto.controller.LottoController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    private final LottoController lottoController = new LottoController();

    @Test
    @DisplayName("당첨 통계 양식이 제대로 생성되는지 확인한다.")
    void createLottoStatistics() {
      // given
        String statisticsForm = LottoStatistics.from(
                        lottoController.createLottoTicket(Buyer.of("5000"))
                        , new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        Bonus.of("7", new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        Buyer.of("5000"))
                .generateLottoStatisticsForm();
        // when & then
        Assertions.assertTrue(
                statisticsForm
                        .contains("3개 일치 (5,000원) - ")
        );
        Assertions.assertTrue(
                statisticsForm
                        .contains("4개 일치 (50,000원) - ")
        );
        Assertions.assertTrue(
                statisticsForm
                        .contains("5개 일치 (1,500,000원) - ")
        );
        Assertions.assertTrue(
                statisticsForm
                        .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
        );
        Assertions.assertTrue(
                statisticsForm
                        .contains("6개 일치 (2,000,000,000원) - ")
        );

    }

}