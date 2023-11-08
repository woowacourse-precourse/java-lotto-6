package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private static final Lotto winningLotto = new Lotto(List.of(3, 14, 15, 9, 2, 6));
    private static final Bonus bonusNumber = new Bonus(5);

    @DisplayName("당첨 번호와 구입한 로또 및 보너스 일치 판별")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void checkPrize(Lotto bought, Rank expected) {
        Rank prize = Rank.from(winningLotto.count(bought), bonusNumber.hasBonusNumber(bought));

        assertThat(prize).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(3, 15, 9, 5, 40, 41)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(3, 15, 9, 45, 40, 41)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 19, 12, 6)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 5, 12, 6)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 9, 12, 6)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(3, 14, 15, 9, 5, 6)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(3, 14, 15, 9, 6, 2)), Rank.FIRST)
        );
    }
}
