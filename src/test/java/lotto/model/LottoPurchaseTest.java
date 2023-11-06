package lotto.model;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseTest {

    @Test
    @DisplayName("구매 금액에 대한 로또의 개수를 반환한다.")
    void purchaseLottery() {
        assertEquals(LottoPurchase.purchaseLottery("8000"),8);
    }

    @Test
    @DisplayName("로또를 2개 발행한다.")
    void createUserLottery() {
        List<Integer> randomNumbers1 = LottoService.createRandomNumbers();
        List<Integer> randomNumbers2 = LottoService.createRandomNumbers();
        List<LottoPurchase> userLottery = new ArrayList<>();

        userLottery.add(LottoPurchase.createUserLottery(randomNumbers1));
        userLottery.add(LottoPurchase.createUserLottery(randomNumbers2));

        assertEquals(userLottery.get(0).getUserLottery(),randomNumbers1);
        assertEquals(userLottery.get(1).getUserLottery(),randomNumbers2);
    }
}