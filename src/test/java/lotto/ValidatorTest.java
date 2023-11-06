package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    private final Validator validator = new Validator();
    private List<String> testCases;

    @BeforeEach
    void init() {
        testCases = null;
    }

    @Test
    @DisplayName("입력값이 공백이거나 null일 시 예외 발생")
    void isSpaceOrNULLTest() {
        testCases = Arrays.asList(new String[]{"", null});
        for (String testCase : testCases) {
            assertThatThrownBy(() -> validator.validate(testCase));
        }
    }
}