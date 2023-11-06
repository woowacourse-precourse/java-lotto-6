package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    private List<String> testCases;

    @BeforeEach
    void init() {
        testCases = null;
    }

    @Test
    @DisplayName("입력값이 공백이거나 null일 시 예외 발생")
    void isBlankOrNULLTest() {
        testCases = Arrays.asList(new String[]{"", null});
        for (String testCase : testCases) {
            assertThatThrownBy(() -> Validator.isBlankOrNULL(testCase));
        }
    }

    @Test
    @DisplayName("공백 문자를 포함할 시 예외 발생")
    void containSpaceTest() {
        testCases = Arrays.asList(new String[]{" 1", "1, 2", "1 ", "1,2 "});
        for (String testCase : testCases) {
            assertThatThrownBy(() -> Validator.containSpace(testCase));
        }
    }
}