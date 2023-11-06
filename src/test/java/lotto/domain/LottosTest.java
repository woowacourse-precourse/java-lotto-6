package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottosTest {

    private static final int FOURTH = Rank.FOURTH.getWinningMoney();
    private static final int FIFTH = Rank.FIFTH.getWinningMoney();

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<Lotto> newLottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8)),
            new Lotto(List.of(1, 2, 3, 7, 8, 9)),
            new Lotto(List.of(1, 2, 7, 8, 9, 10))
        );
        lottos = new Lottos(newLottos);
    }

    @DisplayName("당첨된 금액을 반환한다")
    @ParameterizedTest
    @MethodSource("parametersForGetPriceSum")
    void getPriceSum(WinningLotto winningLotto, int expected) {
        assertThat(lottos.getPriceSum(winningLotto)).isEqualTo(expected);
    }

    static Stream<Arguments> parametersForGetPriceSum() {
        return Stream.of(
            Arguments.of(new WinningLotto(List.of(1, 2, 3, 4, 10, 11), 8),
                FOURTH * 4 + FIFTH * 2),
            Arguments.of(new WinningLotto(List.of(1, 2, 9, 10, 44, 45), 43),
                FOURTH * 1 + FIFTH * 1)
        );
    }
}
