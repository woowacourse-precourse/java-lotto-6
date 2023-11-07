package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameTest {
    Game game = new Game();

    @DisplayName("입력한 개수만큼 랜덤 로또가 만들어진다")
    @Test
    void makeRandomLotto() {
        int size = 8;
        List<Lotto> lottos = game.makeRandomLotto(size);

        Assertions.assertThat(lottos.size()).isEqualTo(size);
    }

    @DisplayName("랜덤로또 전체 검사")
    @Test
    void compareRandomLottosAndInputLotto() {
        Lotto randomLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto randomLotto2 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        Lotto randomLotto3 = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        Lotto randomLotto4 = new Lotto(List.of(1, 2, 3, 17, 18, 19));
        Lotto randomLotto5 = new Lotto(List.of(1, 2, 3, 21, 22, 23));
        Lotto randomLotto6 = new Lotto(List.of(1, 2, 3, 24, 25, 26));

        List<Lotto> randomLottos = new ArrayList<>();
        randomLottos.add(randomLotto1);
        randomLottos.add(randomLotto2);
        randomLottos.add(randomLotto3);
        randomLottos.add(randomLotto4);
        randomLottos.add(randomLotto5);
        randomLottos.add(randomLotto6);
        int[] inputLotto = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 7;
        int[] stats = game.compareRandomLottosAndInputLotto(randomLottos, inputLotto, bonusNumber);
        Assertions.assertThat(stats[1]).isEqualTo(1);
        Assertions.assertThat(stats[5]).isEqualTo(5);

    }

    @DisplayName("단일로또 검사")
    @Test
    void compareOneLottoAndInputLotto() {
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int[] inputLotto = {1, 2, 3, 4, 5, 7};
        int bonusNumber = 6;
        int score = game.compareOneLottoAndInputLotto(randomLotto, inputLotto, bonusNumber);
        Assertions.assertThat(score).isEqualTo(2);
    }

    @DisplayName("수익률 계산 검사")
    @Test
    void calculateProfit() {
        int money=1000;
        int[] stats={0, 0, 0, 0, 0, 1};

        double profit = game.calculateProfit(money, stats);
        Assertions.assertThat(profit).isEqualTo(500.0);
    }
}