package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.validator.BonusValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusValidatorTest {

    private final BonusValidator bonusValidator = new BonusValidator();


    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(숫자가 아님)")
    @Test
    void validationNumericTest() {
        String input = "가";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean result = bonusValidator.validation(input,lotto);

        assertThat(result).isFalse();

    }


    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(중복된 숫자)")
    @Test
    void validationIsDuplicateTest() {
        String input = "1";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean result = bonusValidator.validation(input,lotto);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(범위 밖 숫자)")
    @Test
    void validationRangeTest() {
        String input = "60";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean result = bonusValidator.validation(input,lotto);

        assertThat(result).isFalse();

    }


    @DisplayName("올바른 입력일 경우 True를 리턴한다")
    @Test
    void validationTest() {
        String input = "7";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean result = bonusValidator.validation(input,lotto);

        assertThat(result).isTrue();

    }
}
