package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Test
    void caculateWinners() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        Map<Integer, Integer> winners = lottoGame.caculateWinners(winningNumbers);
        //then
        Assertions.assertThat(winners).isNotEmpty();

    }
}