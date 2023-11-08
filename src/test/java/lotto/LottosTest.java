package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void createLottos() {
        List<Lotto> newLotto = List.of(
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        this.lottos = new Lottos(newLotto);
    }

    @DisplayName("로또 번호를 비교해 일치하는 Rank를 반환한다.")
    @Test
    void testFindRank() {
        Lotto userLotto = new Lotto(List.of(3, 5, 11, 16, 32, 1));
        User user = new User(userLotto, "38");

        Map<Rank, Integer> rankResult = lottos.saveRankResult(user);
        assertThat(rankResult).containsEntry(Rank.FIVE_BONUS, 1);
    }

}
