package lotto.service;

import static lotto.constant.Delimiter.COMMA;
import static lotto.constant.ErrorMessage.MONEY_ONLY_NUMBER;
import static lotto.constant.ErrorMessage.WINNUMBER_COMMA_DELIMITER;
import static lotto.constant.ErrorMessage.WINNUMBER_ONLY_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputWinNumberServiceTest {

    Validator validator;
    @BeforeEach
    void init(){
        validator = new Validator();
    }

    @Test
    void checkRightWinnerNumbers() {


//        List<String> splitedInputWinNumbers = List.of(
//            inputWinnerNumbers.split(COMMA.getDelimiter()));
//        validator.validateRightCommaCount(inputWinnerNumbers, splitedInputWinNumbers);
//        validator.validateWinnumberOnlyNumber(splitedInputWinNumbers);
//        winNumbers = splitedInputWinNumbers.stream().map(Integer::parseInt)
//            .collect(Collectors.toList());
    }


    @ParameterizedTest
    @ValueSource(strings = {",,,", "1,2,3,"})
    @DisplayName("당첨 번호 입력에 올바르게 ,갯수 확인! split할 때 추가적인 경우 확인을 위함!")
    void validateRightCommaCount(String inputWinNumbers) {
        //given
        List<String> splitedInputWinNumbers = List.of(
            inputWinNumbers.split(COMMA.getDelimiter()));

        Assertions.assertThatThrownBy(() -> validator.validateRightCommaCount(inputWinNumbers, splitedInputWinNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(WINNUMBER_COMMA_DELIMITER.getMessage());
    }




    @ParameterizedTest
    @ValueSource(strings = {",as,,", ",2,,@#"})
    @DisplayName("당첨 번호 입력에 올바르게 처리가 되었는지 -> 문자, 공백 포함!")
    void validateWinnumberOnlyNumber(String inputWinNumbers) {
        //given
        List<String> splitedInputWinNumbers = List.of(
            inputWinNumbers.split(COMMA.getDelimiter()));
        System.out.println(splitedInputWinNumbers);

        Assertions.assertThatThrownBy(() -> validator.validateWinnumberOnlyNumber(splitedInputWinNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(WINNUMBER_ONLY_NUMBER.getMessage());
    }













}