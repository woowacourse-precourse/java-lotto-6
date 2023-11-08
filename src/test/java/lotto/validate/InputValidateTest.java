package lotto.validate;

import lotto.errormessage.InputError;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidateTest {

    @DisplayName("로또_범위_초과")
    @Test
    void isCorrectRangeInput(){
        // Given
        String number ="0";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateIsCorrectRange(number));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_OUT_OF_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("1000원단위_나머지_0아닌경우")
    @Test
    void isClearDivideInput(){
        // Given
        String number ="1004";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateIsDivideThousand(number));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NOT_DIVIDE_THOUSAND_ERROR_MESSAGE);
    }

    @DisplayName("로또_문자포함_입력시")
    @Test
    void isNumberInput(){
        // Given
        String number ="12a00";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateIsNumber(number));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NOT_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("로또_숫자_쉼표외_입력포함시")
    @Test
    void isNumberOrRestInput(){
        // Given
        String number ="1,2,3,4,5,a";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateIsNumberOrRest(number));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NOT_NUMBER_OR_REST_ERROR_MESSAGE);
    }

    @DisplayName("로또_초과_사이즈_입력시")
    @Test
    void isExceededSizeInput(){
        // Given
        String number ="1,2,3,4,5,6,7";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateIsSizeCorrect(number));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NOT_CORRECT_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("로또_부족_사이즈_입력시")
    @Test
    void isScarceSizeInput(){
        // Given
        String number ="1,2,3,4";

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateIsSizeCorrect(number));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NOT_CORRECT_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("보너스번호_당첨번호_중복시")
    @Test
    void isBonusNumberDuplicateInput(){
        // Given
        String bonusNumber ="1";
        List<Integer> lottoNumbers = Arrays.asList(1,2,3);

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidate.validateDuplicateNumber(lottoNumbers,bonusNumber));

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_IS_DUPLICATE_NUMBER_ERROR_MESSAGE);
    }
}