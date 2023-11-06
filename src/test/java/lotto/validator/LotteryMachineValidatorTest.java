package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.validator.LotteryMachineValidator.*;
import static org.assertj.core.api.Assertions.*;


class LotteryMachineValidatorTest {

    @Test
    @DisplayName("당첨 번호 입력이 정해진 갯수로 구분되지 않을 때 예외 발생")
    void validateNumberOfLuckyNumberTest() {
        String input = "1,2,3,4";
        assertThatThrownBy(() -> validateLuckyNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력에 정수가아닌 값이 있을 때 예외 발생")
    void validateLuckyNumberIntegerTest() {
        String input = "1,a,2,3,4,5";
        assertThatThrownBy(() -> validateLuckyNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력이 범위를 벗어날 때 예외 발생")
    void validateLuckyNumberRangeTest() {
        String input = "1,2,3,4,5,67";
        assertThatThrownBy(() -> validateLuckyNumber(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 정수가 아닐 때 예외 발생")
    void validateBonusNumberIntegerTest() {
        String input = "aaa";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validateBonusNumber(numbers, input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 이미 당첨 번호에 있을 때 예외 발생")
    void validateBonusNumberDuplicatedTest() {
        String input = "6";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validateBonusNumber(numbers, input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어났을 때 예외 발생")
    void validateBonusNumberRangeTest() {
        String input = "67";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validateBonusNumber(numbers, input))
            .isInstanceOf(IllegalArgumentException.class);
    }


}