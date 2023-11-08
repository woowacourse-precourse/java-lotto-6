package lotto.Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("빈입력 검증")
    @Test
    void emptyCheck() {
        // given
        String value = "";
        // when // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.emptyCheck(value));
    }

    @DisplayName("숫자가 아닌 값 검증")
    @Test
    void numberCheck() {
        // given
        String value = "test";
        // when // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.numberCheck(value));
    }

    @DisplayName("번위 이탈 검증")
    @Test
    void rangeCheck() {
        // given
        int value = 46;
        // when // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.rangeCheck(value));
    }

    @DisplayName("로또 번호(당첨 번호) 중복 여부 검증")
    @Test
    void duplicationCheck() {
        // given
        ArrayList<Integer> winnerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        // when // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.duplicationCheck(winnerNumbers));
    }

    @DisplayName("보너스 번호 중복 여부 검증")
    @Test
    void testDuplicationCheck() {
        // given
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        // when // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.duplicationCheck(winnerNumbers, bonusNumber));
    }

    @DisplayName("입력 단위 검증")
    @Test
    void banknoteCheck() {
        // given
        int value = 1100;
        // when // then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.banknoteCheck(value));
    }
}