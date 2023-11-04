package lotto.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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

    @DisplayName("보유한 개수만큼 티켓을 반환해야 한다.")
    @Test
    void getTicketsTest() {
        // 변수 설정
        LottoManager lotto = new LottoManager();
        int MONEY = 2000;
        int AMOUNT = MONEY / 1000;

        // 티켓 구입
        lotto.buyTickets(MONEY);

        // 티켓 반환
        List<String> tickets = lotto.getTickets();

        // 구입 갯수만큼 반환되었는지 테스트
        assertTrue(tickets.size() == AMOUNT);
    }

}
