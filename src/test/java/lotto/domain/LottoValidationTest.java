package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidationTest {
    LottoValidation lottoValidation;
    List<Integer> lottoNumber;
    @BeforeEach
    void setting() {
        lottoValidation = new LottoValidation();
        lottoNumber = new ArrayList<>();
    }

    @DisplayName("로또 숫자 범위가 아닐 경우 예외")
    @Test
    void checkLottoNumberRangeTest() {
        int[] numbers = {0, 1, 5, 7, 8, 9};
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        assertThat(lottoValidation.checkLottoNumberRange(lottoNumber, 1, 45)).isFalse();
    }

    @DisplayName("로또에 중복된 숫자가 있을 경우 예외")
    @Test
    void checkDuplicateLottoNumberTest() {
        int[] numbers = {5, 9, 10, 14, 17, 17};
        int bonusNumber = 12;
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        boolean notDuplicate = lottoValidation.checkDuplicateLottoNumber(lottoNumber, bonusNumber);

        assertEquals(notDuplicate, false);
    }

    @DisplayName("로또 번호와 보너스 번호 중복일 경우 예외")
    @Test
    void checkDuplicateBonusNumberTest() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 5;
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        boolean notDuplicate = lottoValidation.checkDuplicateLottoNumber(lottoNumber, bonusNumber);

        assertEquals(notDuplicate, false);
    }
}