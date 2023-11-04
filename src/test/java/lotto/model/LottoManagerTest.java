package lotto.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    @DisplayName("구매금액을 입력하면 해당하는 양만큼 티켓을 생성한다.")
    @Test
    void buyTicketsTest() {
        // 변수 설정
        LottoManager lotto = new LottoManager();
        int MONEY = 2000;

        // 초기값 저장
        int initialCount = lotto.getTicketsCount();

        // 티켓 구매 - tickets에 새로운 ticket 추가
        lotto.buyTickets(MONEY);
        int count = lotto.getTicketsCount();

        // tickets가 늘어났는지 확인
        assertTrue(count > initialCount);

    }

}
