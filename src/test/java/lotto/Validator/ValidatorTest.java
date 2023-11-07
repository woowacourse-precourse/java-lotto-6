package lotto.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Validator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ValidatorTest {
    private Validator<String> mockValidator;

    private class MockValidator extends Validator<String> {
        @Override
        public String valid(String input) {
            return input;
        }
    }

    @BeforeAll
    void setUp() {
        mockValidator = new MockValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"123,true", "01192,true","1a928,false", "1 23,false", "1:23,false"})
    void 모든_문자가_숫자인지_확인한다(String input, boolean expected) {
        boolean actualValue = mockValidator.isNumber(input);
        assertEquals(expected, actualValue);
    }
}
