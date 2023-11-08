package lotto;

import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사용자의 입력에 대해서 검증한다.")
public class InputViewTest {

    private final NsTestExtend nsTestExtend;

    private InputViewTest() {
        this.nsTestExtend = new NsTestExtend();
    }

    private InputView getInputView() {
        return new InputView();
    }

    @DisplayName("구입할 로또 금액를 검증한다.")
    @Nested
    public class ValidationLottoPrice {
        @ParameterizedTest
        @ValueSource(strings = {"1000", "2000", "3000", "4000", "10000", "100000"})
        @DisplayName("양의 정수만 입력받을 수 있다.")
        void validateInteger_positiveInteger_notThrowAnyException(String strings) {
            nsTestExtend.inputTestValue(strings);
            Assertions.assertThatCode(() -> getInputView().askPrice())
                    .doesNotThrowAnyException();
        }


        @ParameterizedTest
        @ValueSource(strings = {"-", "ㄱ", "가나", "피자"})
        @DisplayName("문자 입력값은 예외가 발생한다.")
        void validateInteger_invalidCharacter_exceptionThrown(String strings) {
            nsTestExtend.inputTestValue(strings);
            Assertions.assertThatThrownBy(() -> getInputView().askPrice())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {" ", "80 00", "10 000", "10000 ", "\t", "\n"})
        @DisplayName("공백은 예외가 발생한다.")
        void validateBlankAndEmptyInteger_blank_empty_exceptionThrown(String strings) {
            nsTestExtend.inputTestValue(strings);
            Assertions.assertThatThrownBy(() -> getInputView().askPrice())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1.1", "1.2", "1.3", "1.000", "2.0000"})
        @DisplayName("실수 값은 예외가 발생한다.")
        void validateInteger_floating_point_number_exceptionThrown(String strings) {
            nsTestExtend.inputTestValue(strings);
            Assertions.assertThatThrownBy(() -> getInputView().askPrice())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"/", ".", ",", "$", "#"})
        @DisplayName("특수문자 입력값은 예외가 발생한다.")
        void validateInteger_special_character_exceptionThrown(String strings) {
            nsTestExtend.inputTestValue(strings);
            Assertions.assertThatThrownBy(() -> getInputView().askPrice())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -100, -123, -1000, -10000, 0})
        @DisplayName("0 이하의 입력값은 예외가 발생한다.")
        void validateNegativeInteger_negative_integer_exceptionThrown(int ints) {
            nsTestExtend.inputTestValue(ints);
            Assertions.assertThatThrownBy(() -> getInputView().askPrice())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("로또 번호에 대해서 검증한다.")
    @Nested
    public class ValidationLottoNumber {

        @ParameterizedTest
        @ValueSource(strings = {",", ",123,456", ",1,2,3,4,5"})
        @DisplayName("입력된 번호가 문자로 시작하면 예외가 발생한다.")
        void validateFirstCharacter_firstCharacter_exceptionThrown(String strings) {
            Assertions.assertThatThrownBy(() -> getInputView().validateFirstCharacter(strings))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,", "123,456,", "1,2,3,4,5,"})
        @DisplayName("입력된 번호의 마지막이 문자로 끝날 경우 예외가 발생한다.")
        void validateLastCharacter_LastCharacter_exceptionThrown(String strings) {
            Assertions.assertThatThrownBy(() -> getInputView().validateLastCharacter(strings))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
