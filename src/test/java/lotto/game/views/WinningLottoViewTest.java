package lotto.game.views;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.ConsoleTestSuper;
import lotto.app.game.views.WinningLottoView;
import lotto.app.io.ConsoleInput;
import lotto.app.io.ConsoleOutput;
import org.junit.jupiter.api.Test;

class WinningLottoViewTest extends ConsoleTestSuper {

    @Test
    void askWinningNumbers_정상동작확인() {
        String input = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        setIn(input);
        List<Integer> actual = new WinningLottoView(new ConsoleInput(), new ConsoleOutput()).askWinningNumbers();

        assertThat(actual).containsExactly(expected.toArray(Integer[]::new));
    }

}