package lotto.console.game.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrizeDetailTest {

    @DisplayName("당첨 내역 업데이트 - 성공 테스트 [PrizeMatchCount에 의존하는 통합 테스트]")
    @Test
    public void update_detail_by_lotto_success_test() {
        // given
        PrizeDetail prizeDetail = new PrizeDetail();
        List<Integer> playerNumbers = List.of(10,2,3,4,5,7);
        List<Integer> winningNumbers = List.of(10,2,3,4,2,7);
        int bonusNumber = 5;

        // when
        prizeDetail.updateDetailByLotto(playerNumbers, winningNumbers, bonusNumber);

        // then
        assertEquals(0, prizeDetail.getFirstPrizeCount());
        assertEquals(1, prizeDetail.getSecondPrizeCount());
        assertEquals(0, prizeDetail.getThirdPrizeCount());
        assertEquals(0, prizeDetail.getFourthPrizeCount());
        assertEquals(0, prizeDetail.getFifthPrizeCount());
    }

    @DisplayName("당첨 상금 계산 - 성공 테스트")
    @Test
    public void get_prize_money_success_test() {
        // given
        PrizeDetail prizeDetail = new PrizeDetail();
        prizeDetail.addSecondPrizeCount(); // 30000000
        prizeDetail.addFourthPrizeCount(); // 50000
        prizeDetail.addFifthPrizeCount(); // 5000
        prizeDetail.addFifthPrizeCount(); // 5000

        // when & then
        assertEquals(30060000, prizeDetail.getPrizeMoney());
    }
}