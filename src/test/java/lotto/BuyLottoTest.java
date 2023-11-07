package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoTest {
    private static BuyLotto buyLotto = new BuyLotto();

    @DisplayName("등수 계산하는 함수 제대로 작동하는지 확인")
    @Test
    void 등수계산잘되는지확인() {
        assertSimpleTest(() -> {
            buyLotto.paperRank(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7);
            assertThat(7);
        });
    }

    @DisplayName("등수배열초기화되는지확인")
    @Test
    void 등수배열초기화되는지확인() {
        assertSimpleTest(() -> {
            buyLotto.lottoRankInit();
            assertThat(List.of(0, 0, 0, 0, 0));
        });
    }

    @DisplayName("등수기록이잘되는지확인")
    @Test
    void 등수기록이잘되는지확인() {
        assertSimpleTest(() -> {
            buyLotto.lottoRankEdit(new ArrayList<>(List.of(0, 0, 0, 0, 0)), 7);
            assertThat(List.of(0, 0, 0, 0, 1));
        });
    }

    @DisplayName("여러장의로또종이가있을때등수기록이잘되는지확인")
    @Test
    void 여러장의로또종이가있을때등수기록이잘되는지확인() {
        assertSimpleTest(() -> {
            buyLotto.lottoRank(List.of(1, 2, 3, 4, 5, 6), 7);
            List<Lotto> lotto = new ArrayList<>();
            lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
            assertThat(List.of(0, 0, 0, 1, 1));
        });
    }
}
