package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("플레이어가 1000원 단위로 로또를 구매하는 기능 테스트")
    @Test
    public void testBuy() {
        Player player = new Player();
        player.buy(17000);

        List<Lotto> lottos = player.getLottos();
        assertEquals(17, lottos.size());
    }
}
