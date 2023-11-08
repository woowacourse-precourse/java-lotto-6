package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {
    LottoChecker lottoChecker;
    List<Integer> lottoNumber;
    @BeforeEach
    void setting() {
        lottoChecker = new LottoChecker();
        lottoNumber = new ArrayList<>();
    }

    @DisplayName("로또 숫자 범위가 아닐 경우 예외")
    @Test
    void checkLottoNumberRangeTest() {
        int[] numbers = {0, 1, 5, 7, 8, 9};
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        assertThat(lottoChecker.checkLottoNumberRange(lottoNumber, 1, 45)).isFalse();
    }

    @DisplayName("로또에 중복된 숫자가 있을 경우 예외")
    @Test
    void checkDuplicateLottoNumberTest() {
        int[] numbers = {5, 9, 10, 14, 17, 17};
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        assertThat(lottoChecker.checkDuplicateLottoNumber(lottoNumber)).isFalse();
    }

    @DisplayName("보너스 번호 1 ~45 사이의 값인지 테스트")
    @Test
    void checkBonusNumberRangeTest() {
        int bonusNumber = 4;

        assertThat(lottoChecker.checkBonusNumberRange(bonusNumber, 1, 45)).isTrue();
    }

    @DisplayName("보너스 번호 1 ~45 사이의 값이 아닌지 테스트")
    @Test
    void checkBonusNumberNotRangeTest() {
        int bonusNumber = 48;

        assertThat(lottoChecker.checkBonusNumberRange(bonusNumber, 1, 45)).isFalse();
    }

    @DisplayName("보너스 번호 중복이 아닐 경우 테스트")
    @Test
    void checkNotDuplicateBonusNumberTest() {
        int[] numbers = {5, 9, 10, 14, 16, 17};
        int bonusNumber = 4;
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        assertThat(lottoChecker.checkDuplicateBonusNumber(lottoNumber, bonusNumber)).isTrue();
    }

    @DisplayName("보너스 번호 중복일 경우 테스트")
    @Test
    void checkDuplicateBonusNumberTest() {
        int[] numbers = {5, 9, 10, 14, 16, 17};
        int bonusNumber = 17;
        for (int i = 0; i < numbers.length; i++) {
            lottoNumber.add(numbers[i]);
        }

        assertThat(lottoChecker.checkDuplicateBonusNumber(lottoNumber, bonusNumber)).isFalse();
    }

    @DisplayName("로또 당첨 결과 테스트")
    @Test
    void lottoResult() {
        assertEquals(List.of(1, 1, 1, 1, 2), lottoChecker.lottoResult(List.of(3, 4, 3, 5, 10, 6)));
    }
}