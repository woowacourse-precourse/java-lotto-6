package lotto.service;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_RIGHT_RANGE;
import static lotto.constant.ErrorMessage.MONEY_NO_NEGATIVE;
import static lotto.constant.ErrorMessage.MONEY_ONLY_NUMBER;
import static lotto.constant.ErrorMessage.MONEY_UNIT_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.ErrorMessage;
import lotto.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputMoneyServiceTest {

    InputMoneyService inputMoneyService;
    Validator validator;



    @BeforeEach
    void init(){
        inputMoneyService = new InputMoneyService();
        validator = new Validator();
    }


    @ParameterizedTest
    @ValueSource(strings = {"2##@", "2  3", "12,3,"})
    @DisplayName("입력 금액에 숫자가 아닌 문자가 온 경우!")
    void validateInputMoneyIsNumber(String inputMoney) {
        Assertions.assertThatThrownBy(() -> validator.validateInputMoneyIsNumber(inputMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(MONEY_ONLY_NUMBER.getMessage());
    }


    @ParameterizedTest
    @ValueSource(longs = {-1, 0})
    @DisplayName("입력 금액 범위가 0이하인 경우!")
    void validateNumberNegativeOrZero(long inputMoney) {
        Assertions.assertThatThrownBy(() -> validator.validateNumberNegativeOrZero(inputMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(MONEY_NO_NEGATIVE.getMessage());
    }


    @ParameterizedTest
    @ValueSource(longs = {1234, 3200, 11100})
    @DisplayName("입력 금액 단위가 1000이 아닌 경우!")
    void validateNumberUnitIsThousand(long inputMoney) {
        Assertions.assertThatThrownBy(() -> validator.validateNumberUnitIsThousand(inputMoney))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(MONEY_UNIT_NUMBER.getMessage());
    }



}