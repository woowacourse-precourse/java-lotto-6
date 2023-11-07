package mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ValidationMan;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
    ValidationMan testValidationMan = new ValidationMan();

    @Test
    void validateMoneytest() {
        assertThat(testValidationMan.validateMoney("안녕하세요.")).isFalse();
        assertThat(testValidationMan.validateMoney("14500")).isFalse();
    }

    @Test
    void validateNumbers() {
        assertThat(testValidationMan.validateNumbers(new String[]{"1", "2", "3", "4", "5", "휴"}))
                .isFalse();
        assertThat(testValidationMan.validateNumbers(new Integer[]{1, 2, 3, 4, 5, 46}))
                .isFalse();
    }

    @Test
    void validateBonusNumberTest() {
        Integer[] testInt = new Integer[]{1, 2, 3, 4, 5, 6};
        List<Integer> testList = new ArrayList<>(Arrays.asList(testInt));
        Lotto testLotto = new Lotto(testList);
        assertThat(testValidationMan.valudateBonusNumber(testLotto, "휴"))
                .isFalse();
        assertThat(testValidationMan.valudateBonusNumber(testLotto, "6"))
                .isFalse();
    }

}
