package lotto;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AnswerLottoTest {
    @DisplayName("정상 정답 로또인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @MethodSource("validAnswerLottoProvider")
    void createAnswerLottoWithValid(Lotto lotto, BonusNumber bonus) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new AnswerLotto(lotto, bonus));
    }

    static Stream<Arguments> validAnswerLottoProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(20, 39, 22, 40, 17, 32)), new BonusNumber(13),
                        Arguments.of(new Lotto(List.of(45, 1, 26, 12, 21, 8)), new BonusNumber(4)),
                        Arguments.of(new Lotto(List.of(7, 37, 19, 43, 5, 29)), new BonusNumber(35))
                ));
    }

    @DisplayName("보너스 숫자가 1~45 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidBonusProvider")
    void createAnswerLottoWithInvalidBonus(Lotto lotto, BonusNumber bonus) {
        Assertions.assertThatThrownBy(() -> new AnswerLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidBonusProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(12, 31, 24, 9, 37, 4)), new BonusNumber(0)),
                Arguments.of(new Lotto(List.of(5, 18, 27, 42, 11, 38)), new BonusNumber(46)),
                Arguments.of(new Lotto(List.of(21, 8, 33, 10, 15, 30)), new BonusNumber(-2))
        );
    }

    @DisplayName("로또 숫자와 보너스 숫자가 겹치는 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("duplicateNumberProvider")
    void createAnswerLottoWithDuplicate(Lotto lotto, BonusNumber bonus) {
        Assertions.assertThatThrownBy(() -> new AnswerLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> duplicateNumberProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(2, 43, 6, 29, 19, 34)), new BonusNumber(6)),
                Arguments.of(new Lotto(List.of(7, 28, 14, 44, 23, 3)), new BonusNumber(3)),
                Arguments.of(new Lotto(List.of(35, 16, 41, 25, 36, 13)), new BonusNumber(35))
        );
    }
}
