package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputTest {
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @ParameterizedTest
    @CsvSource(value = {"389", "-1000", "글자"})
    void 구입_금액_잘못된_값_입력(String invalidValue) {
        assertThatThrownBy(() -> userInput.validateMoney(invalidValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"100", "-100", "글자"})
    void 당첨_번호_잘못된_값_입력(String invalidValue) {
        assertThatThrownBy(() -> userInput.validateNumber(invalidValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}