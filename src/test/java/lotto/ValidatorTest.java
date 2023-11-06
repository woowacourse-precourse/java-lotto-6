package lotto;

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
    void isBlankOrNULLTest() {
        stringTestCases = Arrays.asList(new String[]{"", null});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.isBlankOrNULL(testCase));
        }
    }

    @Test
    @DisplayName("공백 문자를 포함할 시 예외 발생")
    void containSpaceTest() {
        stringTestCases = Arrays.asList(new String[]{" 1", "1, 2", "1 ", "1,2 "});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.containSpace(testCase));
        }
    }

    @Test
    @DisplayName("양의 정수가 아닐 경우 예외 발생")
    void isNumberTest() {
        stringTestCases = Arrays.asList(new String[]{"a", "asdf", "120a", "!230"});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.isNumber(testCase));
        }
    }

    @Test
    @DisplayName("1000원으로 나누어 떨어지지 않을 경우 예외 발생")
    void isDividedByTest() {
        numberTestCases = Arrays.asList(new Integer[]{1001, 1100, 3500, 9});
        for (Integer testCase : numberTestCases) {
            assertThatThrownBy(() -> Validator.isDividedBy(1000, testCase));
        }
    }

    @Test
    @DisplayName(",,가 포함되어 있거나 ,로 시작하거나 끝날 경우 예외 발생")
    void containInvalidComma() {
        stringTestCases = Arrays.asList(new String[]{"1,,2", ",1,2", "1,2,", ",1", "1,"});
        for (String testCase : stringTestCases) {
            assertThatThrownBy(() -> Validator.containInvalidComma(testCase));
        }
    }
}