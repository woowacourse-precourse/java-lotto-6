package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.exception.ExceptionMessage.DIFFERENT_FORMAT_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.MAX_PRICE_MESSAGE;
import static lotto.exception.ExceptionMessage.NOT_NUMBER_EXCEPTION_MESSAGE;
import static lotto.exception.ExceptionMessage.NULL_POINTER_EXCEPTION_MESSAGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lotto.exception.LottoApplicationException;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class InputTest {

    private InputView inputView = new InputView();
    private InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource(value = {"   공 백 테 스트,공백테스트", "  공백 테스   트,공백테스트"})
    @DisplayName("공백 제거 정상적으로 작동하는 지 테스트")
    public void 공백_제거_테스트(String input, String expected) {
        assertThat(inputView.removeWhitespace(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력에 Null값이 들어가는 경우")
    public void Null_입력_예외(String input) {
        assertThatThrownBy(() -> inputValidator.validateNotNull(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(NULL_POINTER_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a2b3c",".2.","3 c"})
    @DisplayName("입력에 숫자외 문자가 들어갈 경우")
    public void 숫자_외_문자_입력_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validateNumber(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(NOT_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111","0","1023","100000001","999","111"})
    @DisplayName("금액이 1,000원 단위가 아닌 입력시, 예외 테스트")
    public void 금액_단위_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validatePurchasePrice(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(DIFFERENT_FORMAT_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000000000000","2100000001"})
    @DisplayName("설정한 최대 금액보다 초과할 경우 예외 테스트")
    public void 최대_금액_테스트(String input) {
        assertThatThrownBy(() -> inputValidator.validateMaxPrice(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(MAX_PRICE_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("separateData")
    @DisplayName("구분자 분할 테스트")
    public void 구분자_분할_테스트(String input, List<String> expected) {
        assertThat(inputValidator.separateInput(input)).isEqualTo(expected);
    }

    static Stream<Arguments> separateData(){
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", Arrays.asList("1","2","3","4","5","6")),
                Arguments.of("1,10,5,2,7,6", Arrays.asList("1","10","5","2","7","6"))
        );
    }

    @ParameterizedTest
    @MethodSource("notNumberLuckyNumberData")
    @DisplayName("당첨번호에 숫자 외 문자 입력 됐을 경우 예외 테스트")
    public void 당첨번호_숫자_외_입력_테스트(List<String> input) {
        assertThatThrownBy(() -> inputValidator.validateLuckyNumberIsNumber(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessageContaining(NOT_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }

    static Stream<Arguments> notNumberLuckyNumberData(){
        return Stream.of(
                Arguments.of(Arrays.asList("1,a,b,c")),
                Arguments.of(Arrays.asList("c1")),
                Arguments.of(Arrays.asList("',1,2,3")),
                Arguments.of(Arrays.asList(" ,1,2,  ,3,4,"))
        );
    }


    @ParameterizedTest
    @MethodSource("stringToInteger")
    @DisplayName("구분자 분할 테스트")
    public void 구분자_분할_테스트(List<String> input, List<Integer> expected) {
        assertThat(inputView.convertLuckyNumberForm(input)).isEqualTo(expected);
    }

    static Stream<Arguments> stringToInteger(){
        return Stream.of(
                Arguments.of(Arrays.asList("1","2","3","4","5","6"), Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(Arrays.asList("44","12","6","2","7","9"), Arrays.asList(44,12,6,2,7,9))
        );
    }



}
