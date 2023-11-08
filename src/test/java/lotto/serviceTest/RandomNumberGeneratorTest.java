package lotto.serviceTest;

import lotto.domain.Lotto;
import lotto.service.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberGeneratorTest {

    @DisplayName("유저가 구매한 로또갯수와 발행된 로또 갯수 비교")
    @Test
    void testUserLottoBetweenPurchaseLotto() {
        int userPurchase = 8;
        List<Lotto> lottos = new RandomNumberGenerator(userPurchase).generateRandomNumber();
        assertEquals(userPurchase, lottos.size());
    }

}
