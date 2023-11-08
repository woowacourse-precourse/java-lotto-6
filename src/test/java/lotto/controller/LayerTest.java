package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningInformation;
import lotto.utils.message.InputExceptionMessage;
import lotto.utils.message.LottoExceptionMessage;
import lotto.utils.message.PurchaseAmountExceptionMessage;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * while 무한 루프 내에서 요청하는
 * View, Domain Layer에 대한 Exception 테스트
 */
public class LayerTest {

    private static final String ERROR_CODE = "[ERROR]";

    @Nested
    @DisplayName("구매 금액 입력 했을 때")
    class PurchaseAmountLayerTest {
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "  ", "   ", "     ", "\n", "\t", "\r"})
        @DisplayName("[Exception] 공백 입력 시 view에서 예외가 발생한다.")
        void blank(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {" 1000", "2000 ", "1  ", "김준기   ", "꾸꾸     "})
        @DisplayName("[Exception] 공백 포함 입력 시 view에서 예외가 발생한다.")
        void blankMix(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234567890", "1          ", "           2"})
        @DisplayName("[Exception] 9자리 초과 입력 시 view에서 예외가 발생한다.")
        void exceedLength(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.EXCEED_PURCHASE_AMOUNT_LENGTH.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"r1000", "200O ", "i000", "ㄱ000", "부부부"})
        @DisplayName("[Exception] 숫자가 아닌 문자 포함 시 view에서 예외가 발생한다.")
        void notNumeric(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000", "58571000", "2323000", "12312000", "100000000"})
        @DisplayName("[Exception] 공백 X, 9자리 이내, 숫자만 포함이면 view에서 예외가 발생하지 않는다.")
        void correct(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatCode(inputView::readPurchaseAmount)
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"999", "-1", "0", "-123123", "100000001"})
        @DisplayName("[Exception] 1천원 ~ 1억 범위가 아닐 시 domain에서 예외가 발생한다.")
        void outOfRange(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new PurchaseAmount(inputView.readPurchaseAmount()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1100", "2010", "3001", "40000100", "5000999"})
        @DisplayName("[Exception] 1000원 단위가 아닐 시 domain에서 예외가 발생한다.")
        void invalidUnit(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new PurchaseAmount(inputView.readPurchaseAmount()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(PurchaseAmountExceptionMessage.INVALID_AMOUNT_UNIT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000", "11000", "345000", "12345000", "1212000"})
        @DisplayName("[Exception] 올바른 구매 금액이면 view와 domain에서 예외가 발생하지 않는다.")
        void correctPurchaseAmount(String correctInput) {
            InputView inputView = new InputView(() -> correctInput);
            Assertions.assertThatCode(() -> new PurchaseAmount(inputView.readPurchaseAmount()))
                    .doesNotThrowAnyException();
        }

    }

    @Nested
    @DisplayName("당첨 번호를 입력했을 때")
    class WinningNumberLayerTest {

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "  ", "   ", "     ", "\n", "\t", "\r"})
        @DisplayName("[Exception] 공백 입력 시 view에서 예외가 발생한다.")
        void blank(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"12,13,14,15,16,18,20,10", "123,456,789,23,1,2411", "21474836472147483647 ",
                "   ㄱ            q   !"})
        @DisplayName("[Exception] 20자리 초과 입력 시 view에서 예외가 발생한다.")
        void exceedLength(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.EXCEED_WINNING_NUMBER_LENGTH.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {",1,2,3,4,5,6", ",,12,23,24,25,26,17"})
        @DisplayName("[Exception] 첫 문자로 콤마 입력 시 view에서 예외가 발생한다.")
        void firstCharacterComma(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.FIRST_CHARACTER_COMMA.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6,", "12,23,24,25,26,17,,"})
        @DisplayName("[Exception] 마지막 문자로 콤마 입력 시 view에서 예외가 발생한다.")
        void lastCharacterComma(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.LAST_CHARACTER_COMMA.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,,3,4,5,6", "12, ,24,25,26,17", "34,김,1,2,3,45", "1,2,\n,3,4,5,6"})
        @DisplayName("[Exception] 콤마로 구분된 문자가 숫자가 아닐 시 view에서 예외가 발생한다.")
        void notNumeric(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,0", "12,13,14,46,1,3", "1,2,-1,34,42,27"})
        @DisplayName("[Exception] 1 ~ 45 범위가 아닐 시 domain에서 예외가 발생한다.")
        void outOfRange(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new Lotto(inputView.readWinningNumbers()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,1", "12,44,14,44,1,2", "1,27,34,42,27,2"})
        @DisplayName("[Exception] 중복 숫자가 존재 시 domain에서 예외가 발생한다.")
        void duplicate(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new Lotto(inputView.readWinningNumbers()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_UNIQUE.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2,3", "11,12,18", "1,2,3,4", "23,24,25,26,31", "35,36,37,38,39,40,45"})
        @DisplayName("[Exception] 숫자가 6개가 아닐 경우 domain에서 예외가 발생한다.")
        void outOfCount(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(() -> new Lotto(inputView.readWinningNumbers()))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "1,45,2,34,23,12", "45,44,43,1,2,3"})
        @DisplayName("[Exception] 올바른 당첨 번호이면 view와 domain에서 예외가 발생하지 않는다.")
        void correctWinningNumber(String correctInput) {
            InputView inputView = new InputView(() -> correctInput);
            Assertions.assertThatCode(() -> new Lotto(inputView.readWinningNumbers()))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("보너스 번호를 입력했을 때")
    class BonusNumberLayerTest {

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "  ", "   ", "     ", "\n", "\t", "\r"})
        @DisplayName("[Exception] 공백 입력 시 view에서 예외가 발생한다.")
        void blank(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readBonusNumber)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.BLANK.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1  ", "100", " 12", "1 1", "2 3", "-10"})
        @DisplayName("[Exception] 2자리 초과 입력 시 view에서 예외가 발생한다.")
        void exceedLength(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readBonusNumber)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.EXCEED_BONUS_NUMBER_LENGTH.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1 ", "r2", "I", "김", "뚜룼"})
        @DisplayName("[Exception] 숫자가 아닌 문자 포함 시 view에서 예외가 발생한다.")
        void notNumeric(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            Assertions.assertThatThrownBy(inputView::readBonusNumber)
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(InputExceptionMessage.NOT_NUMERIC.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "-1", "46"})
        @DisplayName("[Exception] 1 ~ 45 범위가 아닐 시 domain에서 예외가 발생한다.")
        void outOfRange(String wrongInput) {
            InputView inputView = new InputView(() -> wrongInput);
            int bonusNumber = inputView.readBonusNumber();
            Assertions.assertThatThrownBy(() -> new LottoNumber(bonusNumber))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
        }

        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:1", "12,13,21,31,41,42:12"}, delimiter = ':')
        @DisplayName("[Exception] 당첨 번호와 중복일 시 domain에서 예외가 발생한다.")
        void duplicate(String winningNumberInput, String bonusNumberInput) {
            InputView inputView1 = new InputView(() -> winningNumberInput);
            Lotto winningNumber = new Lotto(inputView1.readWinningNumbers());

            InputView inputView2 = new InputView(() -> bonusNumberInput);
            LottoNumber bonusNumber = new LottoNumber(inputView2.readBonusNumber());

            Assertions.assertThatThrownBy(() -> new WinningInformation(winningNumber, bonusNumber))
                    .hasMessageContaining(ERROR_CODE)
                    .hasMessage(LottoExceptionMessage.WINNING_AND_BONUS_DUPLICATE_EXISTS.getError());
        }

        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:12"}, delimiter = ':')
        @DisplayName("[Exception] 올바른 보너스 번호이면 view와 domain에서 예외가 발생하지 않는다.")
        void correctBonusNumber(String winningNumberInput, String bonusNumberInput) {
            InputView inputView1 = new InputView(() -> winningNumberInput);
            Lotto winningNumber = new Lotto(inputView1.readWinningNumbers());

            InputView inputView2 = new InputView(() -> bonusNumberInput);
            LottoNumber bonusNumber = new LottoNumber(inputView2.readBonusNumber());

            Assertions.assertThatCode(() -> new WinningInformation(winningNumber, bonusNumber))
                    .doesNotThrowAnyException();
        }
    }
}
