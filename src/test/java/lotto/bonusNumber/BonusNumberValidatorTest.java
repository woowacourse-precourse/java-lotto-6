package lotto.bonusNumber;

import com.sun.jdi.request.DuplicateRequestException;
import lotto.validator.input.BonusNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BonusNumberValidatorTest {
    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @Test
    void validate_WinningNumbers와_중복이_없으면_참을_반환한다() {
        String userInput = "11";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumberValidator.validateAndParse(userInput, winningNumbers);
    }

    @Test
    void validate_WinningNumbers와_중복이_있으면_거짓을_반환한다() {
        String userInput = "11";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 11);
        Assertions.assertThrows(DuplicateRequestException.class,
                () -> bonusNumberValidator.validateAndParse(userInput, winningNumbers));
    }
}
