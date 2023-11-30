package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeNumbersTest {

    @ParameterizedTest
    @DisplayName("당첨 번호에 중복되는 보너스 번호는 예외가 발생한다.")
    @ValueSource(ints = {1, 3, 4})
    void validateBonusNumberDuplicationTest(int source) {
        PrizeNumbers prizeNumbers = new PrizeNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThatThrownBy(() -> prizeNumbers.validateBonusNumberDuplication(source))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @DisplayName("당첨번호와 로또가 몇개 맞는지 테스트 ")
    @MethodSource("provideMatchedWinningNumberCountList")
    void matchedWinningNumberCountTest(Lotto lotto, Integer expectedMatchCount) {
        PrizeNumbers prizeNumbers = new PrizeNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(prizeNumbers.matchedWinningNumberCount(lotto)).isEqualTo(expectedMatchCount);

    }

    static Stream<Arguments> provideMatchedWinningNumberCountList() {
        return Stream.of(
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 7, 8, 9, 10, 11))), 1),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 8, 9, 10, 11))), 2),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 9, 10, 11))), 3),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10, 11))), 4),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 11))), 5),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))), 6),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(14, 12, 8, 9, 10, 11))), 0)

        );
    }

    @ParameterizedTest
    @DisplayName("보너스번호와 로또가 몇개 맞는지 테스트 ")
    @MethodSource("provideMatchedBonusNumberCountList")
    void matchedBonusNumberCountTest(Lotto lotto, Boolean expectedMatch) {
        PrizeNumbers prizeNumbers = new PrizeNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prizeNumbers.setBonusNumber(7);
        assertThat(prizeNumbers.matchedBonusNumber(lotto)).isEqualTo(expectedMatch);

    }

    static Stream<Arguments> provideMatchedBonusNumberCountList() {
        return Stream.of(
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 7, 8, 9, 10, 11))), true),
                Arguments.of(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 8, 9, 10, 11))), false)
        );
    }
}