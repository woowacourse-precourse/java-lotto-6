package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProcessTest {
    private LottoProcess lottoProcess;

    @BeforeEach
    void setUP() {
        lottoProcess = new LottoProcess();
    }

    @DisplayName("로또 개수에 해당하는 만큼 로또를 발행한다.")
    @Test
    void buyLotto() {
        int input = 6;
        List<Lotto> result = lottoProcess.buyLotto(input);

        assertThat(result.size()).isEqualTo(6);
    }

    @DisplayName("주어진 로또 리스트와 당첨 로또를 이용하여 등수 정보가 들어있는 Rank 리스트를 봔한한다")
    @Test
    void makeRanks() {
        Lotto one = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto two = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        Lotto three = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        List<Lotto> inputLottos = List.of(one, two, three);
        WinningLotto inputWinningLotto = new WinningLotto(new Lotto(List.of(4, 5, 6, 7, 8, 9)), 10);
        List<Rank> result = lottoProcess.makeRanks(inputLottos, inputWinningLotto);

        assertThat(result.get(0)).isEqualTo(Rank.THREE_MATCH);
        assertThat(result.get(1)).isEqualTo(Rank.SIX_MATCH);
        assertThat(result.get(2)).isEqualTo(Rank.FIVE_MATCH_AND_BONUS);
    }
}