package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumberTest {

    @Test
    @DisplayName("공백 시 예외처리")
    void isBlankTest() {
        //given
        List<Integer> input = List.of();
        //then
        assertThatThrownBy(() -> new WinnerNumber(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수의 범위가 1 미만 45 초과 시 예외처리")
    void isRightRangeTest() {
        //given
        List<Integer> input = Arrays.asList(0, 30, 8);
        //then
        assertThatThrownBy(() -> new WinnerNumber(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 숫자가 6개가 아닐 시 예외처리")
    void isSizeTest() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //then
        assertThatThrownBy(() -> new WinnerNumber(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 숫자 내부에서 중복된 것이 있으면 예외처리")
    void isDuplicateTest() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 3);
        //then
        assertThatThrownBy(() -> new WinnerNumber(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

}