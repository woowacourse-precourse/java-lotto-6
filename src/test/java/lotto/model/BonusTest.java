package lotto.model;

import static lotto.view.ErrorMessage.DUPLICATED_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {
//    @DisplayName("보너스번호가 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
//    @ParameterizedTest
//    @ValueSource(ints = {1, 5, 2, 3, 4, 6})
//    void createBonusByDuplicatedNumber(int input) {
//        //given
//        Set<Integer> firstPrizeNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
//        //when
//        assertThatThrownBy(() -> new Bonus(input, firstPrizeNumbers))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("로또 번호가 최대 로또 번호보다 크면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {46, 47, 48, 1023})
    void createBonusByGreaterThanMaxNumber(int input) {
        //when
        assertThatThrownBy(() -> new Bonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 최소 로또 번호보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -123})
    void createBonusByLessThanMinNumber(int input) {
        //when
        assertThatThrownBy(() -> new Bonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 테스트")
    @ParameterizedTest
    @ValueSource(ints = {23, 45, 10})
    void createBonus(int input) {
        //given
        int expect = input;
        //when
        Bonus bonus = new Bonus(input);
        int result = bonus.getNumber();

        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("보너스 번호와 겹치는 1등 로또 번호 예외처리")
    @ParameterizedTest
    @MethodSource("provideBonusAndIntegerSet")
    void validate_1등_로또_번호(Bonus bonus, Set<Integer> winningNumbers) {
        assertThatThrownBy(() -> bonus.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER.getMessage());

    }

    private static Stream<Arguments> provideBonusAndIntegerSet() {
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(new Bonus(1), winningNumbers),
                Arguments.of(new Bonus(2), winningNumbers),
                Arguments.of(new Bonus(3), winningNumbers),
                Arguments.of(new Bonus(4), winningNumbers),
                Arguments.of(new Bonus(5), winningNumbers),
                Arguments.of(new Bonus(6), winningNumbers)
        );
    }
}
