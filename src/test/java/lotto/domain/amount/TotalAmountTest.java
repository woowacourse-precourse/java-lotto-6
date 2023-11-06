package lotto.domain.amount;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.enums.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("TotalAmount 클래스")
class TotalAmountTest {

    private TotalAmount totalAmount;

    @BeforeEach
    void setup() {
        totalAmount = TotalAmount.initial();
    }

    @DisplayName("총 금액의 초기 값은 0이다.")
    @Test
    void initialTotalAmountIsZero() {
        assertEquals(0, totalAmount.getAmount());
    }

    @DisplayName("로또 당첨금은 총 금액에 누적된다.")
    @Test
    void accumulateLottoPrizeToTotalAmount() {
        totalAmount = totalAmount.addLottoPrize(LottoPrize.FIFTH);
        totalAmount = totalAmount.addLottoPrize(LottoPrize.FOURTH);

        int expectedTotal = LottoPrize.FIFTH.getPrizeAmount() + LottoPrize.FOURTH.getPrizeAmount();
        assertEquals(expectedTotal, totalAmount.getAmount()); // getAmount() 메서드를 통한 값 확인
    }
}