package lotto;

import lotto.domain.Consumer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.impl.GameShop;
import lotto.impl.LottoGame;
import lotto.impl.RandomNumberImpl;
import lotto.type.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameShopTest {

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
        List<Lotto> lottos = gameShop.purchase(BUY_AMOUNT);
        Assertions.assertEquals(8, lottos.size());
    }

    @DisplayName("로또 1등 당첨")
    @Test
    void prizeFirst() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 3, 4, 5, 6, 8)));
        gameShop.startLottoGame(new WinningLotto(new ArrayList<>(List.of(1, 3, 4, 5, 6, 8)), 7));
        Prize prize = gameShop.getResult(lotto);
        Assertions.assertEquals(Prize.FIRST, prize);
    }

    @DisplayName("로또 2등 당첨")
    @Test
    void prizeSecond() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 3, 4, 5, 6, 8)));
        gameShop.startLottoGame(new WinningLotto(new ArrayList<>(List.of(1, 3, 4, 5, 8, 9)), 6));
        Prize prize = gameShop.getResult(lotto);
        Assertions.assertEquals(Prize.SECOND, prize);
    }

}