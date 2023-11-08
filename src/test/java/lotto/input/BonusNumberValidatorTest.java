package lotto.input;

import lotto.exception.input.DuplicatedNumberException;
import lotto.view.input.validator.BonusNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@Nested
@DisplayName("BonusNumber 입력 검증 테스트")
public class BonusNumberValidatorTest {
    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @Test
    @DisplayName("정답 번호와 중복되지 않으면 성공한다.")
    void success() {
        String userInput = "11";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumberValidator.validate(userInput, winningNumbers);
    }

    @Test
    @DisplayName("정답 번호와 중복되면 예외가 발생한다.")
    void fail() {
        String userInput = "11";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 11);
        Assertions.assertThrows(DuplicatedNumberException.class,
                () -> bonusNumberValidator.validate(userInput, winningNumbers));
    }
}
