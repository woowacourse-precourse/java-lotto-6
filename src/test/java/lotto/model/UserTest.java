package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;
    private final double EARN_MONEY = 5000;
    private final double SPEND_MONEY = 8000;

    @BeforeEach
    void createUser() {
        Money money = new Money(String.valueOf((int) SPEND_MONEY));
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    user = new User(money);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("유저의_로또_결과_계산")
    void getLottoResults() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");

        Assertions.assertThat(user.getLottoResults(winningLotto))
                .contains(LottoResult.FIFTH);
    }

    @Test
    @DisplayName("유저의_로또_수익률_계산")
    void getStatistics() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        user.getLottoResults(winningLotto);
        double expectedStatistics = EARN_MONEY * 100 / SPEND_MONEY;

        Assertions.assertThat(user.getStatistics())
                .isEqualTo(expectedStatistics);
    }
}