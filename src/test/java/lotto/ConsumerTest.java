package lotto;

import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.impl.GameShop;
import lotto.impl.LottoGame;
import lotto.impl.RandomNumberImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerTest {

    static int BUY_AMOUNT = 8;
    private GameShop gameShop;
    private Consumer consumer;

    @BeforeEach
    void before() {
        gameShop = new GameShop(new LottoGame(new RandomNumberImpl()));
    }
    @DisplayName("사용자가 입력한 수량만큼 로또 구매")
    @Test
    void createLottoByAmount() {
        consumer = Consumer.purchaseLotto(gameShop.purchase(BUY_AMOUNT));
        Assertions.assertEquals(8, consumer.getPurchasedLotto().size());
    }

    @DisplayName("사용자의 수익률을 소수점 둘째자리에서 반올림하여 반환")
    @Test
    void getConsumerReturnRate() {
        consumer = Consumer.purchaseLotto(new ArrayList<>(List.of(new Lotto(new ArrayList<>(List.of(1, 3, 4, 5, 6, 8))),
                new Lotto(new ArrayList<>(List.of(2, 3, 4, 5, 6, 7))))));
        gameShop.startLottoGame(new WinningLotto(List.of(1, 3, 4, 6, 8, 9), 14));
        consumer.setPrizeResult(gameShop.getResults(consumer.getPurchasedLotto()));
        Assertions.assertEquals((double) (1500000 + 5000) / 2000, consumer.getReturnRate());
    }
}