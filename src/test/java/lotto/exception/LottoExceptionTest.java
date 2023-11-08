package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoExceptionTest {

    @Test
    @DisplayName("로또 숫자가 중복이면 예외처리")
    void isDuplicate() {
        //given
        List<Integer> input = Arrays.asList(1, 1, 3);
        //then
        assertThatThrownBy(() -> new LottoException(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자가 6개가 아니면 예외처리")
    void isSize() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //then
        assertThatThrownBy(() -> new LottoException(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자가 1 미만 45 초과 시 예외처리")
    void isRightRange() {
        //given
        List<Integer> input = Arrays.asList(0, 30, 8);
        //then
        assertThatThrownBy(() -> new LottoException(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자가 오름차순이 아니면 예외처리")
    void isAscendingOrder() {
        //given
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(4);
        input.add(2);
        input.add(5);
        input.add(6);
        //then
        assertThatThrownBy(() -> new LottoException(input)).isInstanceOf(
                IllegalStateException.class);
    }


}