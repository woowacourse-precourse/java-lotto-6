package lotto.domain.purchase.lottocount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryCountServiceTest {
    private LotteryCountService lotteryCountService;

    @BeforeEach
    void setUp() {
        lotteryCountService = new LotteryCountService();
    }

    @AfterEach
    void tearDown() {
        lotteryCountService = null;
    }

    @ParameterizedTest
    @DisplayName("정책에 따라, 금액을 입력하면 티켓 개수를 반환합니다.")
    @ValueSource(ints = {1000})
    void 천원단위_1이상_정수_금액(Integer cashInput) {
        // WHEN
        Integer lottoCount = lotteryCountService.getTicketCount(cashInput);

        // THEN
        assertEquals(1, lottoCount);
    }
}