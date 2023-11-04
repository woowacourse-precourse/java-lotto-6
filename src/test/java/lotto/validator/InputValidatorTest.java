//package lotto.validator;
//
//import lotto.message.ErrorMessage;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class InputValidatorTest {
//
//    private InputValidator inputValidator = new InputValidator();
//
//    @Test
//    @DisplayName("숫자가 1000의 단위가 아닌경우 예외가 발생한다.")
//    public void checkIsMultipleOfDenomination() {
//        // given
//        int number = 1200;
//        int denomination = 1000;
//        // when // then
//        assertThatThrownBy(() -> inputValidator.validateMultipleOfDenomination(number, denomination))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
//    }
//
//    @ParameterizedTest(name = "{index}: 숫자가 {0}이면 예외가 발생한다.")
//    @DisplayName("숫자가 0보다 크지 않으면 예외가 발생한다.")
//    @ValueSource(ints = {0, -1000, -1500})
//    public void checkIsValidLottoAmount(int number) {
//        // when // then
//        assertThatThrownBy(() -> inputValidator.validateLottoAmount(number))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
//    }
//
//    @Test
//    @DisplayName("숫자가 아니면 예외가 발생한다.")
//    public void parseInt() {
//        // given
//        String notNumber = "haen";
//        // when // then
//        assertThatThrownBy(() -> inputValidator.parseInt(notNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
//    }
//
//    @Test
//    @DisplayName("번호들이 1~45사이의 숫자가 아니면 예외가 발생한다.")
//    public void validateLottoNumberRangeList() {
//        // given
//        List<Integer> numbers = List.of(1, 2, 3, 46, 5, 6);
//        // when // then
//        assertThatThrownBy(() -> inputValidator.validateLottoNumberRange(numbers))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
//    }
//
//    @Test
//    @DisplayName("로또 번호의 개수가 6이 아니면 예외가 발생한다.")
//    public void validateLottoSize() {
//        // given
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        // when // then
//        assertThatThrownBy(() -> inputValidator.validateLottoSize(numbers))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
//    }
//
//    @Test
//    @DisplayName("번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
//    public void validateLottoNumberRange() {
//        // given
//        int number = 0;
//        // when // then
//        assertThatThrownBy(() -> inputValidator.validateLottoNumberRange(number))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
//    }
//
//}