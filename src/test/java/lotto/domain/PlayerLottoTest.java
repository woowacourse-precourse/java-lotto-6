package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerLottoTest {
    static class 플레이어_로또_생성 extends NsTest {

        @Test
        @DisplayName("플레이어 로또 생성 확인")
        void 플레이어_로또_생성_확인() {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run();
                    },
                    List.of(8, 21, 23, 41, 42, 43),
                    List.of(3, 5, 11, 16, 32, 38)
            );
        }

        @Override
        protected void runMain() {
            PlayerLotto playerLotto = new PlayerLotto(2000);

            List<Lotto> answer = List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                    new Lotto(List.of(3, 5, 11, 16, 32, 38)));

            for (int i = 0; i < 2; i++) {
                assertThat(
                        playerLotto.getPlayerLottos().get(i).getNumbers()
                ).isEqualTo(
                        answer.get(i).getNumbers()
                );
            }

            assertThat(playerLotto.getLottoAmount()).isEqualTo(2);
        }
    }
}