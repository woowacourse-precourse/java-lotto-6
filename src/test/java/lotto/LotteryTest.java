package lotto;

import lotto.domain.lotto.Lottery;
import lotto.utils.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    RandomGenerator fakeRandomGenerator;

    @BeforeEach
    void setUp() {
        fakeRandomGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("구입 금액 단위 만큼의 로또를 생성한다.")
    void name() {
        Lottery lottery = Lottery.of("10000", fakeRandomGenerator);

        assertThat(lottery).isEqualTo(Lottery.of("10000", fakeRandomGenerator));
    }

    @Test
    @DisplayName("toString 메서드는 로또를 출력한다.")
    void toStringTest() {
        Lottery lottery = Lottery.of("3000", fakeRandomGenerator);

        String expected =
                """
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 6]
                """;
        assertThat(lottery.toString())
                .isEqualTo(expected);
    }
}