package lotto.service;

import lotto.model.LottoPurchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseServiceTest {
    LottoPurchaseService lottoPurchaseService;

    @BeforeEach
    void setup(){
        lottoPurchaseService = new LottoPurchaseService();
    }
    @DisplayName("구매 개수 만큼 로또 발행")
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    void issueLotteryByPurchaseAmount(int count) {
        List<LottoPurchase> userLotteries = lottoPurchaseService.issueLotteryByPurchaseAmount(count);
        assertEquals(userLotteries.size(),count);
    }
}