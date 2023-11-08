package lotto;

import lotto.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    private List<String> stringTestCases;
    private List<Integer> numberTestCases;

    @BeforeEach
    void init() {
        stringTestCases = null;
        numberTestCases = null;
    }

    @Test
    @DisplayName("입력값이 공백이거나 null일 시 예외 발생")
    void checkBlankOrNULLTest() {
        stringTestCases = Arrays.asList(new String[]{"", null});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.checkBlankOrNULL(testCase));
        }
    }

    @Test
    @DisplayName("공백 문자를 포함할 시 예외 발생")
    void checkContainSpaceTest() {
        stringTestCases = Arrays.asList(new String[]{" 1", "1, 2", "1 ", "1,2 "});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.checkContainSpace(testCase));
        }
    }

    @Test
    @DisplayName("양의 정수가 아닐 경우 예외 발생")
    void checkNANTest() {
        stringTestCases = Arrays.asList(new String[]{"a", "asdf", "120a", "!230"});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.checkNAN(testCase));
        }
    }

    @Test
    @DisplayName("1000원으로 나누어 떨어지지 않을 경우 예외 발생")
    void checkDividedByTest() {
        numberTestCases = Arrays.asList(new Integer[]{1001, 1100, 3500, 9});
        for (Integer testCase : numberTestCases) {
            assertThatThrownBy(() -> Validator.checkDividedBy(1000, testCase));
        }
    }

    @Test
    @DisplayName(",,가 포함되어 있거나 ,로 시작하거나 끝날 경우 예외 발생")
    void checkInvalidCommaTest() {
        stringTestCases = Arrays.asList(new String[]{"1,,2", ",1,2", "1,2,", ",1", "1,"});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.checkInvalidComma(testCase));
        }
    }

    @Test
    @DisplayName(",를 기준으로 분리한 배열의 크기가 6이 아닐 경우 예외 발생")
    void checkValidSizeTest() {
        stringTestCases = Arrays.asList(new String[]{"1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7"});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.checkValidSize(testCase));
        }
    }

    @Test
    @DisplayName("입력값이 1이상 45이하가 아닐 경우 예외 발생")
    void checkNumberInTest() {
        numberTestCases = Arrays.asList(new Integer[]{0, 46, 47, 48, 49, 1000000});
        for (Integer testCase : numberTestCases) {
            assertThatThrownBy(() -> Validator.checkNumberIn(1, 45, testCase));
        }
    }

    @Test
    @DisplayName("중복입력이 있을 경우 예외 발생")
    void checkDuplicatedTest() {
        numberTestCases = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 5});
        assertThatThrownBy(() -> Validator.checkDuplicated(numberTestCases));
    }

    @Test
    @DisplayName("기존 리스트에 존재하는 숫자일경우 예외 발생")
    void checkNumberInListTest() {
        numberTestCases = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        assertThatThrownBy(() -> Validator.checkNumberInList(3, numberTestCases));
    }
}