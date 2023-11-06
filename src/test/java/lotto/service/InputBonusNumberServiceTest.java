package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputBonusNumberServiceTest {

    InputBonusNumberService inputBonusNumberService;
    Validator validator;

    @BeforeEach
    void init() {
        inputBonusNumberService = new InputBonusNumberService();
        validator = new Validator();
    }

    @Test
    void checkRightBonusNumberInput() {
//
//        validator.validateBonusNumberInput(bonusNumberInput);
//        int convertedBonusNumber = Integer.parseInt(bonusNumberInput);
//        validator.validateBonusNumberRange(convertedBonusNumber);
//        validator.validateIsBonusNumberInWinnerNumber(lottoWinNumbers, convertedBonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "bb2", "x3", ",4", "", " "})
    @DisplayName("보너스 번호 입력에 숫자가 아닌 이상한 문자가 오게 된 경우!")
    void validateBonusNumberInput(String bonusNumberInput) {
        Assertions.assertThatThrownBy(() -> validator.validateBonusNumberInput(bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 0})
    @DisplayName("보너스 번호의 숫자가 범위를 벗어난 경우!")
    void validateBonusNumberRange(int convertedBonusNumber) {
        Assertions.assertThatThrownBy(() -> validator.validateBonusNumberRange(convertedBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }










}