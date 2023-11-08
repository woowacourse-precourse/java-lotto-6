package lotto.domain;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Number;
import lotto.domain.lotto.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

@DisplayName("사용자 숫자들 객체에 대해")
class NumbersTest {

    static Stream<List<Integer>> numberValuesSource() {
        return Stream.of(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @MethodSource("numberValuesSource")
    @DisplayName("각 숫자들을 Number 객체들로 저장한다.")
    void Given_CreateNumbers_When_GetNumberValues_Then_InstanceOfNumber(List<Integer> value) {
        //given
        Numbers numbers = new Numbers(value);

        //when
        List<Number> numberValues = numbers.getValues();

        //then
        numberValues.forEach(number -> assertThat(number).isInstanceOf(Number.class));
    }

    @ParameterizedTest
    @MethodSource("numberValuesSource")
    @DisplayName("각 숫자들의 개수와 일치하게 저장한다.")
    void Given_CreateNumbers_When_GetNumberValues_Then_EqualSize(List<Integer> value) {
        //given
        Numbers numbers = new Numbers(value);

        //when
        List<Number> numberValues = numbers.getValues();

        //then
        assertThat(numberValues).hasSize(6);
    }

    @Test
    @DisplayName("각 숫자들이 오름차순 정렬되어 저장된다.")
    void Given_CreateNumbers_When_GetNumberValues_Then_NumbersAsc() {
        //given
        Numbers numbers = new Numbers(List.of(43, 42, 41, 23, 22, 8));

        //when
        List<Number> numberValues = numbers.getValues();
        List<Integer> numbersAsc = numberValues.stream()
                .map(Number::getValue)
                .toList();

        //then
        assertThat(numbersAsc).isEqualTo(List.of(8, 22, 23, 41, 42, 43));
    }

    @Test
    @DisplayName("당첨 번호와 비교하여 일치하는 개수를 얻는다.")
    void Given_CreateNumbers_When_SameListGetMatchCount_Then_Expected6() {
        //given
        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));

        //when
        Long matchCount = numbers.getMatchCount(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호가 일치하면 true를 반환한다.")
    void Given_CreateNumbers_When_MatchBonusNumber_Then_ReturnTrue() {
        //given
        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = mock(BonusNumber.class);
        given(bonusNumber.isMatchBonusNumber(3)).willReturn(true);

        //when
        Boolean isMatchBonusNumber = numbers.isMatchBonusNumber(bonusNumber);

        //then
        assertTrue(isMatchBonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 일치하지 않으면 false를 반환한다.")
    void Given_CreateNumbers_When_NotMatchBonusNumber_Then_ReturnFalse() {
        //given
        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = mock(BonusNumber.class);
        given(bonusNumber.isMatchBonusNumber(7)).willReturn(false);

        //when
        Boolean isMatchBonusNumber = numbers.isMatchBonusNumber(bonusNumber);

        //then
        assertFalse(isMatchBonusNumber);
    }

}
