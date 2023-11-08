package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.Constants.*;
import static lotto.utils.ErrorMessages.CHECK_NUMBER_IN_RANGE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class GenerateRandomNumTest {
    @Test
    @DisplayName("pickNumber 메서드 테스트")
    public void pickNumber() {
        List<Integer> numbers = GenerateRandomNum.pickNumber();
        assertThat(numbers).hasSize(LOTTO_SIZE);
        assertThat(numbers).allMatch(num -> num >= MIN_NUMBER_IN_RANGE && num <= MAX_NUMBER_IN_RANGE);
    }

    @Test
    @DisplayName("checkNumberInRange 메서드 테스트 - 1과 45사이의 범위의 숫자가 맞을 때")
    public void checkNumberInRange_ValidNumbers_DoesNotThrowException() {
        List<Integer> validNumbers = Arrays.asList(10, 20, 30, 40, 45, 1);

        assertThatCode(() -> GenerateRandomNum.checkNumberInRange(validNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("checkNumberInRange 메서드 테스트 - 1과 45사이의 범위의 숫자가 아닐 때")
    public void checkNumberInRange_InvalidNumbers_ThrowsException() {
        List<Integer> invalidNumbers = Arrays.asList(-5, 0, 46, 50);

        assertThatThrownBy(() -> GenerateRandomNum.checkNumberInRange(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CHECK_NUMBER_IN_RANGE);
    }
}

