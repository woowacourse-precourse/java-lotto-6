package lotto.model;

import static lotto.model.WinningLotto.BONUS;
import static lotto.model.WinningLotto.SIX;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("사용자의 당첨 로또들을 조회한다.")
    public void 사용자의_당첨_로또들을_조회한다() {
        //given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        User user = new User(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        List<WinningLotto> winningLottos = lottos.getWinningLottos(user);

        //then
        assertThat(winningLottos).hasSize(2);
        assertThat(winningLottos).contains(SIX, BONUS);
    }
}
