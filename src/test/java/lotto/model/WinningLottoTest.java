package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("duplicateNumber")
    @DisplayName("당첨 번호, 보너스 번호 중복 테스트")
    void duplicateNumberTest(List<Integer> winningLotto, int bonusNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> new WinningLotto(new Lotto(winningLotto), new BonusNumber(bonusNumber)));
    }

    static Stream<Arguments> duplicateNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 1),
                Arguments.of(Arrays.asList(40,41,42,43,44,45), 45)
        );
    }
}
