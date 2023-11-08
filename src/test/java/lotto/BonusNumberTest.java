package lotto;

import java.util.List;
import lotto.Model.BonusNumber;
import lotto.Model.Lotto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    public void validateIsNumeric_InvalidInput_ShouldThrowIllegalArgumentException() {
        String invalidInput = "abc";

        assertThrows(IllegalArgumentException.class, () -> BonusNumber.validateIsNumeric(invalidInput));
    }

    @Test
    public void validateIsNumberInRange_NumberOutOfRange_ShouldThrowIllegalArgumentException() {
        int numberOutOfRange = 0;
        assertThrows(IllegalArgumentException.class,
                () -> BonusNumber.validateIsNumberInRange(numberOutOfRange));
    }

    @Test
    public void validateBonusNumberDuplicate_DuplicateBonusNumber_ShouldThrowIllegalArgumentException() {
        int bonusNumber = 5;
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Lotto.validateBonusNumberDuplicate(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
