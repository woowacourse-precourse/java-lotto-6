package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.Constant;
import lotto.enums.ErrorMessage;
import lotto.model.Bonus;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusTest {
    private static final Lotto lotto = new Lotto(givenNumbers(1, 2, 3, 4, 5, 6));
    @DisplayName("숫자의 범위가 1 ~ 45를 벗어나면 에러가 발생합니다.")
    @Test
    void createBonusByOverRangeNumber() {
        assertThatThrownBy(() -> new Bonus(46, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        ErrorMessage.LOTTO_NUMBERS_HAS_RANGE.getMessage(),
                        Constant.START_RANGE_OF_NUMBER.getContentToInteger(),
                        Constant.END_RANGE_OF_NUMBER.getContentToInteger()
                ));
    }

    @DisplayName("기존 로또 번호와 보너스 번호는 중복될 수 없습니다.")
    @Test
    void createBonusByDuplicateNumberWithLotto() {
        assertThatThrownBy(() -> new Bonus(6, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_HAS_NO_DUPLICATE.getMessage());
    }

    @ParameterizedTest(name = "임의의 숫자 : {0}, 로또 : {1}, 예상 결과 : {2}")
    @MethodSource("numbersAndExpected")
    @DisplayName("임의의 로또에 대해 보너스 번호를 포함하는지 판별할 수 있어야 합니다.")
    void countMatchesByGivenNumber(Integer test, Lotto testLotto, Integer expected) {
        Bonus bonus = new Bonus(test, lotto);

        assertThat(bonus.countMatchesBonus(testLotto)).isEqualTo(expected);
    }

    static Stream<Arguments> numbersAndExpected() {
        return Stream.of(
                Arguments.arguments(7, new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)), 0),
                Arguments.arguments(7, new Lotto(givenNumbers(2, 3, 4, 5, 6, 7)), 1),
                Arguments.arguments(45, new Lotto(givenNumbers(7, 8, 9, 10, 11, 12)), 0)
        );
    }

    private static List<Integer> givenNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .collect(Collectors.toList());
    }
}
