package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    
    @Test
    @DisplayName("정상적인 로또 발행 테스트")
    void lottoTest() {
        //given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto validLotto = new Lotto(validNumbers);

        //then
        for (Integer validNumber : validNumbers) {
            assertThat(validLotto.contains(validNumber)).isTrue();
        }
    }

    @Test
    @DisplayName("6개의 숫자가 아닐 경우 예외 처리")
    void sizeTest() {
        //given
        List<Integer> longNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //when & then
        assertThatThrownBy(() -> new Lotto(longNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자가 있을 경우 예외 처리")
    void duplicateTest() {
        //given
        List<Integer> duplicateNumbers = List.of(1, 1, 2, 3, 4, 5);

        //when & then
        assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("음수 입력시 예외 처리")
    void negativeNumberTest() {
        //given
        List<Integer> negativeNumbers = List.of(-1, 1, 2, 3, 4, 5);

        //when & then
        assertThatThrownBy(() -> new Lotto(negativeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("1보다 작은 숫자가 있을 경우 예외 처리")
    void rangeTest1() {
        //given
        List<Integer> lowNumbers = List.of(0, 1, 2, 3, 4, 5);

        //when & then
        assertThatThrownBy(() -> new Lotto(lowNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("45보다 큰 숫자가 있을 경우 예외 처리")
    void rangeTest2() {
        //given
        List<Integer> highNumbers = List.of(1, 2, 3, 4, 5, 46);

        //when & then
        assertThatThrownBy(() -> new Lotto(highNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_ERROR.getMessage());
    }

}
