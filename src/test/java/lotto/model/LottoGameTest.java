package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest extends NsTest {
    private LottoGame game = new LottoGame();

    @DisplayName("구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또미발행() {
        assertThatThrownBy(() -> game.setLottoPurchaseAmount("8550"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 숫자여야한다.")
    @Test
    void 숫자가아닌당첨번호() {
        assertThatThrownBy(() -> game.setWinningLotto("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("구입금액만큼 로또를 발행한다.")
    @Test
    void 로또발행() {
        game.setLottoPurchaseAmount("10000");
        game.createLottoTickets();
        assertThat(game.getPurchasedLottos().size()).isEqualTo(10);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬한다.")
    @Test
    void 로또번호오름차순정렬() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[1, 2, 3, 4, 5, 6]"
                    );
                },
                List.of(5, 3, 6, 1, 2, 4)
        );
    }

    @DisplayName("로또 추첨")
    @Test
    void 로또추첨() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(5, 3, 6, 1, 2, 4),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}