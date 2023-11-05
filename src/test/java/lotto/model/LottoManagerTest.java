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
        String MONEY = "2000";

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
        String MONEY = "2000";
        int money = 2000;
        int AMOUNT = money / 1000;

        // 티켓 구입
        lotto.buyTickets(MONEY);

        // 티켓 반환
        List<String> tickets = lotto.getTickets();

        // 구입 갯수만큼 반환되었는지 테스트
        assertTrue(tickets.size() == AMOUNT);
    }

    @DisplayName("당첨번호와 보유중인 티켓을 비교하여 일치하는 갯수를 반환한다.")
    @Test
    void checkTickets() {
        // 변수 설정
        LottoManager lotto = new LottoManager();
        String MONEY = "2000";
        String winning = "1,2,3,4,5,6";
        String bonus = "7";
        int POINT_MIN = 0;
        int POINT_MAX = 7;

        // 티켓 구입
        lotto.buyTickets(MONEY);

        // 티켓 확인
        List<Integer> points = lotto.getTicketPoint(winning, bonus);

        // 반환값이 예상범위 내인지 테스트
        for (int point : points) {
            assertTrue(POINT_MIN <= point);
            assertTrue(point <= POINT_MAX);
        }

    }

}
