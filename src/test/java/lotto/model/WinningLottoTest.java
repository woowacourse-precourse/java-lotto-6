package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName} Lotto:{0}, Bonus:{1}")
    @MethodSource("parametersProvider")
    void createDuplicateWinningLottoAndBonus(Lotto lotto, Bonus bonus) {
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(2)),
                Arguments.of(new Lotto(List.of(10, 12, 24, 20, 6, 30)), new Bonus(30))
        );
    }
}
