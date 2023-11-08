package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    @DisplayName("당첨 번호가 공백이 입력되면 예외가 발생한다.")
    @Test
    void createWinningNumberByIsEmpty() {
        String input = "";

        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 쉼표가 입력되지 않은 경우 예외가 발생한다.")
    @Test
    void createWinningNumberByNotComma() {
        String input = "1.2.3.4.5.6";

        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아닐 때 예외 발생한다.")
    @Test
    void createWinningNumber() {
        String input = "1,2,3,e,4,5";

        assertThatThrownBy(() -> new WinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 등수를 계산한다.")
    @MethodSource("provideLottoNumbersAndEqualityCount")
    void createLottoRanking(List<Integer> lottoNumber, String bonusNumber, String expectPrize) {
        String input = "1,2,3,4,5,6";
        WinningNumber winningNumber = new WinningNumber(input);

        LottoRanking lottoRanking = winningNumber.calculateLottoRanking(new Lotto(lottoNumber),
                new BonusNumber(winningNumber, bonusNumber));

        assertEquals(expectPrize, lottoRanking.name());
    }

    private static Stream<Arguments> provideLottoNumbersAndEqualityCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "7", "FIRST"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), "7", "SECOND"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), "9", "THIRD"),
                Arguments.of(List.of(1, 2, 3, 4, 8, 10), "10", "FOURTH"),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), "11", "FIFTH"),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), "12", "NO_MATCH")
                );
    }
}
