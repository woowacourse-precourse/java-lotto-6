package lotto.console.game.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrizeManagerTest {
    @DisplayName("당첨 내역 생성 - 성공 테스트 [PrizeDetail에 의존하는 통합 테스트]")
    @Test
    public void generate_prize_detail_by_lottos_success_test() {
        // given
        PrizeManager prizeManager = new PrizeManager();
        prizeManager.registerWinningNumbers(List.of(10,2,3,4,5,7));
        prizeManager.registerBonusNumber(1);
        List<Lotto> lottos = List.of(new Lotto(List.of(10,2,3,4,5,7)), new Lotto(List.of(10, 2, 3, 4, 5, 1)));

        // when
        PrizeDetail prizeDetail = prizeManager.generatePrizeDetailByLottos(lottos);

        // then
        assertEquals(1, prizeDetail.getFirstPrizeCount());
        assertEquals(1, prizeDetail.getSecondPrizeCount());
        assertEquals(0, prizeDetail.getThirdPrizeCount());
        assertEquals(0, prizeDetail.getFourthPrizeCount());
        assertEquals(0, prizeDetail.getFifthPrizeCount());
    }

}