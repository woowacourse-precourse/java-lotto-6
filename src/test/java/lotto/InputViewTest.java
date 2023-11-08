package lotto;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    void testValidIntType() {
        assertEquals(1000, inputView.validIntType("1000"));
        assertThrows(IllegalArgumentException.class, () -> inputView.validIntType("abc"));
    }

    @Test
    void testValidUnit() {
        assertDoesNotThrow(() -> inputView.validUnit(1000));
        assertThrows(IllegalArgumentException.class, () -> inputView.validUnit(1050));
    }

    @Test
    void testValidPositive() {
        assertDoesNotThrow(() -> inputView.validPositive(1000));
        assertThrows(IllegalArgumentException.class, () -> inputView.validPositive(-1000));
    }

    @Test
    void testSplitNumbers() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actual = inputView.splitNumbers("1,2,3,4,5,6");
    }

    @Test
    void testValidLottoNumber() {
        // Assuming this method checks if a string contains valid lotto numbers
        List<Integer> lottoNumbers = inputView.validLottoNumber("1, 2, 3, 4, 5, 6");
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, lottoNumbers);
        assertThrows(IllegalArgumentException.class, () -> inputView.validLottoNumber("1, 2, 3, a, 5, 6"));
    }

    @Test
    void testValidDelimiter() {
        assertDoesNotThrow(() -> inputView.validDelimeter("1, 2, 3, 4, 5, 6"));
        assertThrows(IllegalArgumentException.class, () -> inputView.validDelimeter("1; 2; 3; 4; 5; 6"));
    }

    @Test
    void testValidRange() {
        assertDoesNotThrow(() -> inputView.validRange(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThrows(IllegalArgumentException.class, () -> inputView.validRange(Arrays.asList(0, 2, 3, 4, 5, 45)));
    }

}
