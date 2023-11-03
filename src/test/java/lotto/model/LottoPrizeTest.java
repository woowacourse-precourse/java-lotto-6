package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    private static final Lotto winningLotto = new Lotto(List.of(3, 14, 15, 9, 2, 6));
    private static final int bonusNumber = 5;

    @DisplayName("당첨 번호와 구입한 로또 및 보너스 일치 판별")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void checkPrize(Lotto bought, LottoPrize expected) {
        LottoPrize prize = LottoPrize.from(bought.count(winningLotto), bought.contains(bonusNumber));

        assertThat(prize).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(3, 15, 9, 5, 40, 41)), LottoPrize.THREE_MATCH),
                Arguments.of(new Lotto(List.of(3, 15, 9, 45, 40, 41)), LottoPrize.THREE_MATCH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 19, 12, 6)), LottoPrize.FOUR_MATCH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 5, 12, 6)), LottoPrize.FOUR_MATCH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 9, 12, 6)), LottoPrize.FIVE_MATCH),
                Arguments.of(new Lotto(List.of(3, 14, 15, 9, 5, 6)), LottoPrize.FIVE_WITH_BONUS),
                Arguments.of(new Lotto(List.of(3, 14, 15, 9, 6, 2)), LottoPrize.SIX_MATCH)
        );
    }
}