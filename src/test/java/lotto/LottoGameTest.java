package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.controller.NumberGenerator;
import lotto.utils.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @DisplayName("올바른 번호가 생성되는지 확인한다.")
    @Test
    public void testNumberGeneratorGenerate() {
        NumberGenerator numberGenerator = new NumberGenerator();

        List<Integer> generatedNumbers = numberGenerator.generate();

        assertEquals(6, generatedNumbers.size());
        assertTrue(generatedNumbers.stream().allMatch(n -> n >= 1 && n <= 45));
        assertTrue(generatedNumbers.stream().distinct().count() == 6);
    }

    @DisplayName("중복된 번호에 대한 유효성 검사가 동작하는지 확인한다.")
    @Test
    public void testLottoValidation() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertDoesNotThrow(() -> new Lotto(validNumbers));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @DisplayName("사용자 입력에 대한 유효성 검사를 하는지 확인한다.")
    @Test
    public void testUserInputValidation() {
        assertDoesNotThrow(() -> UserInput.validateNonNumeric("1234"));
        assertThrows(IllegalArgumentException.class, () -> UserInput.validateNonNumeric("12a34"));
        assertDoesNotThrow(() -> UserInput.validateUnit(2000));
        assertThrows(IllegalArgumentException.class, () -> UserInput.validateUnit(1500));
    }
}
