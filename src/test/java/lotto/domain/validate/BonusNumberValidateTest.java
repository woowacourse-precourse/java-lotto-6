package lotto.domain.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberValidateTest {
    InputValidator inputValidator;
    List<Integer> lottoNumbers;

    @BeforeEach
    void SetUp() {
        inputValidator = new InputValidator();
        lottoNumbers = List.of(1,2,3,4,5,6);
    }

    @Test
    void 보너스_번호_입력_성공() {
        String validatedInput = "23";

        assertDoesNotThrow(() -> inputValidator.validateBonusNumber(validatedInput,lottoNumbers));
    }
}
