package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private LottoGame lottoGame = new LottoGame();

    @Test
    void buyLotto() {
        //given
        //when
        List<Lotto> lottos =lottoGame.buyLotto(8);
        //then
        Assertions.assertThat(lottos).hasSize(8);

    }
}