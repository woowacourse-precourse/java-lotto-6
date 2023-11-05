package lotto.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GameControllerTest {
    Game game = new Game();

    @Test
    void 로또_번호는_오름차순으로_정렬하여_출력() {
        // given
        int price = 1000;
        // when & then
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                game.purchaseLotto(price);
                assertThat(game.getPurchasedLottosInfo()).contains(
                    "1개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]"
                );
            },
            List.of(8, 23, 21, 41, 42, 43)
        );
    }
}
