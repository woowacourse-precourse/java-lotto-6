package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;
    @BeforeEach
    void init() {
        this.game = new Game();
    }

    @DisplayName("로또를 6개 생성한다.")
    @Test
    void generateLottoSix() {
        List<Lotto> lottos = game.issueLottos(10);
        assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("로또 번호가 5개가 같고 보너스 넘버가 맞으면 2등이다.")
    @Test
    void getSecondRank() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 5, 6, 7)));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Method method = game.getClass().getDeclaredMethod("assignEachRank", Lotto.class, int.class, List.class);
        method.setAccessible(true);

        List<Rank> ranks = (List<Rank>) method.invoke(game, winningNumbers, 7, lottos);

        assertThat(ranks.get(0)).isEqualTo(Rank.second);
    }
}
