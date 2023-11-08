package lotto;

import lotto.validator.BonusLottoValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BonusLottoTest {
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

    @DisplayName("보너스 번호가 숫자가 아니거나 2개 이상일 경우 에러가 발생합니다.")
    @Test
    void testInvalidBonusLotto() {
        String bonusLotto = "7, 5";
        BonusLottoValidator.isInvalid(bonusLotto);
        assertTrue(captor.toString().trim().contains("[ERROR]"));

        String bonusLotto2 = "invalid bonus lotto";
        BonusLottoValidator.isInvalid(bonusLotto2);
        assertTrue(captor.toString().trim().contains("[ERROR]"));

        String bonusLotto3 = "";
        BonusLottoValidator.isInvalid(bonusLotto3);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }

    @DisplayName("보너스 번호의 범위가 1 ~ 45의 숫자가 아닐 경우 에러가 발생합니다.")
    @Test
    void testBonusLottoOutOfRange() {
        String bonusLotto = "46";
        BonusLottoValidator.isInvalidNumber(bonusLotto);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }

    @DisplayName("보너스 번호가 이미 당첨 번호에 있을 때 에러가 발생합니다.")
    @Test
    void testBonusLottoDuplicated() {
        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,6);
        String bonusLotto = "6";
        BonusLottoValidator.isDuplicated(bonusLotto, winningLotto);
        assertTrue(captor.toString().trim().contains("[ERROR]"));
    }
}
