package lotto.service;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_NOT_NUPLICATED_WINNUMBER;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_ONLY_NUMBER;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_RIGHT_RANGE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
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


    @ParameterizedTest
    @ValueSource(strings = {"a", "bb2", "x3", ",4", "", " "})
    @DisplayName("보너스 번호 입력에 숫자가 아닌 이상한 문자가 오게 된 경우!")
    void validateBonusNumberInput(String bonusNumberInput) {
        Assertions.assertThatThrownBy(() -> validator.validateBonusNumberInput(bonusNumberInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(BONUS_NUMBER_ONLY_NUMBER.getMessage());
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 0})
    @DisplayName("보너스 번호의 숫자가 범위를 벗어난 경우!")
    void validateBonusNumberRange(int convertedBonusNumber) {
        Assertions.assertThatThrownBy(() -> validator.validateBonusNumberRange(convertedBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(BONUS_NUMBER_RIGHT_RANGE.getMessage());
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3,4,5,6})
    @DisplayName("보너스 번호의 숫자 당첨 번호 숫자 내부에 들어있는 경우!")
    void validateBonusNumberInWinNumbers(int convertedBonusNumber) {
        //given
        List<Integer> lottoWinNumbers = List.of(1,2,3,4,5,6);
        //then
        Assertions.assertThatThrownBy(() -> validator.validateIsBonusNumberInWinnerNumber(lottoWinNumbers, convertedBonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(BONUS_NUMBER_NOT_NUPLICATED_WINNUMBER.getMessage());
    }










}