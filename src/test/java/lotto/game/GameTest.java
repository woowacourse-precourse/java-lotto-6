package lotto.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행() {
        // given
        int price = 8000;
        // when
        game.purchaseLotto(price);
        // then
        assertThat(game.getPurchasedLottosInfo()).contains("8개를 구매했습니다.");
    }

    @Test
    void 사용자가_구매한_로또_번호와_당첨_번호를_비교하여_당첨_내역_및_수익률을_산출() {
        // given
        int price = 4000;
        // when & then
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                game.purchaseLotto(price);
                game.setWinningLotto(List.of(8, 21, 23, 11, 16, 32), 7);
                assertThat(game.getLottoWinningResult()).contains(
                    "4개를 구매했습니다.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "3개 일치 (5,000원) - 2개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 0개",
                    "총 수익률은 250.0%입니다."
                );
            },
            List.of(8, 23, 21, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
    }
}
