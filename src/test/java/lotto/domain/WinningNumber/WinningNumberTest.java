package lotto.domain.WinningNumber;

import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningNumberTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    WinningNumberValidator validator = new WinningNumberValidator();
    ByteArrayOutputStream outputContent;

    @BeforeEach
    void setUpStreams() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("로또 번호가 적절하지 않은 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkLottoNumberValidTest() {
        assertThatThrownBy(() -> validator.checkLottoNumberValid("2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 에러메시지 출력 확인")
    @Test
    void checkLottoNumberValidLengthTest() {
        assertThatThrownBy(() -> validator.checkLottoNumberValid("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("로또 번호가 중복인 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkLottoDuplicateTest() {
        List<String> lotto = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "5"));
        assertThatThrownBy(() -> validator.checkLottoDuplicate(lotto))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("로또 번호가 1부터 45사이가 아닌 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkLottoNumberInRangeTest() {
        List<String> lotto = new ArrayList<>(Arrays.asList("1", "100", "2", "3", "4", "5"));
        assertThatThrownBy(() -> validator.checkLottoInRange(lotto))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 에러메시지 출력 확인")
    @Test
    void checkBonusNumberValidTest() {
        assertThatThrownBy(() -> validator.checkBonusNumberIsNumber("2j"))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("보너스 번호가 1부터 45사이가 아닌 경우 예외 발생 및 에러메시지 출력 확인")
    @Test
    void checkBonusNumberInRangeTest() {
        assertThatThrownBy(() -> validator.checkBonusNumberInRange(46))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

    @DisplayName("보너스 번호가 로또 번호와 중복인 경우 예외 발생 및 에러메시지 출력")
    @Test
    void checkBonusDuplicateTest() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.checkBonusDuplicate(lotto, 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertTrue(outputContent.toString().contains("[ERROR]"));
    }

}
