package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.BuyAmount;
import lotto.domain.BuyLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyLottosTest {
    @DisplayName("서로 다른 로또 발행")
    @Test
    void createLottoByOverSize() {
        int numberOfLottos = 6;
        BuyLottos buyLottos = new BuyLottos(numberOfLottos);
        long distinctCount = buyLottos.getBuyLottos().stream().distinct().count();
        assertThat(distinctCount == buyLottos.getBuyLottos().size()).isTrue();
    }
}
