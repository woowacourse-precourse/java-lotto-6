package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.message.ValidateErrorMessage;
import lotto.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {


    @DisplayName("구입 금액이 1000원 단위 이상 정수인 경우, 예외가 발생한다.")
    @Test
    void validatePayment(){
        Validator validator = new Validator();
        Assertions.assertThatThrownBy(() -> validator.validate(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateErrorMessage.PAYMENT_ERROR.getMessage());

    }

    @DisplayName("로또 번호가 6개 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateNumbersSize(){
        assertValidateNumbers(Arrays.asList(1,2,3,4,5,6,7), ValidateErrorMessage.LOTTO_SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateNumberRange(){
        assertValidateNumbers(Arrays.asList(100,1,2,3,4,5), ValidateErrorMessage.LOTTO_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 서로 다른 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateDifferentNumber(){
        assertValidateNumbers(Arrays.asList(1,1,2,3,4,5), ValidateErrorMessage.LOTTO_SAME_NUMBER_ERROR.getMessage());
    }

    private static void assertValidateNumbers(List<Integer> numbers, String exceptionMessage) {
        Validator validator = new Validator();
        Assertions.assertThatThrownBy(()->validator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateBonusNumberRange(){
        assertValidateBonusNumber(100, ValidateErrorMessage.LOTTO_ERROR.getMessage());

    }
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateDifferentBonusNumber(){
        assertValidateBonusNumber(1, ValidateErrorMessage.LOTTO_SAME_NUMBER_ERROR.getMessage());
    }
    private static void assertValidateBonusNumber(int bonusNumber, String exceptionMessage) {
        Validator validator = new Validator();
        Assertions.assertThatThrownBy(()-> validator.validate(bonusNumber, Arrays.asList(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }
}
