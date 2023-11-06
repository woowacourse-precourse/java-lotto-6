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
}