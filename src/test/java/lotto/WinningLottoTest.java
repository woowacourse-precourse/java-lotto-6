package lotto;

import lotto.validator.WinningLottoValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningLottoTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("당첨 번호에 숫자 이외의 특수문자가 있을 경우 예외가 발생한다.")
    @Test
    void createNonNumericWinningNumber() {
        String winningNumber = "1,2,3,4,K,6";
        WinningLottoValidator.isInvalid(winningNumber);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }

    @DisplayName("당첨 번호 입력 문자열에 쉼표외의 특수문자가 있을 경우 예외가 발생한다.")
    @Test
    void containsSpecialCharacterInput() {
        String winningNumber = "1,2,3,4.5.6";
        WinningLottoValidator.hasSpecialCharacter(winningNumber);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberCount() {
        String winningNumber = "1,2,3,4,5";
        WinningLottoValidator.isInvalidSize(winningNumber);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }

    @DisplayName("당첨 번호에 중복된 번호가 있으면 예외가 발생한다.")
    @Test
    void checkDuplicatedWinningNumber() {
        String winningNumber = "1,2,3,4,5,5";
        WinningLottoValidator.isDuplicated(winningNumber);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberOutOfRange() {
        String winningNumber = "1,2,3,4,5,47";
        WinningLottoValidator.isInvalidNumber(winningNumber);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }
}

