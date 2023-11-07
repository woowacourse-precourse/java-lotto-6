package lotto;

import lotto.validator.InputWinningNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputWinningNumbersValdatorTest {

    InputWinningNumbersValidator inputWinningNumbersValidator = new InputWinningNumbersValidator();

    @Test
    @DisplayName("로또 당첨 번호 입력 안함 테스트")
    void 로또_당첨_번호_입력_안함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonInputWinningNumbers(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 6개가 아닌 경우 테스트")
    void 로또_당첨_번호_6개_미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonNumberSizeSix("1,2,3,4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 6개가 아닌 경우 테스트2")
    void 로또_당첨_번호_6개_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonNumberSizeSix("1,2,3,4,5,6,7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 1~45 사이 아닌 경우 테스트")
    void 로또_당첨_번호_범위_이탈() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateWrongRangeWinningNumbers("0,1,2,3,4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 1~45 사이 아닌 경우 테스트2")
    void 로또_당첨_번호_범위_이탈2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateWrongRangeWinningNumbers("1,2,3,40,45,50"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 중복된 숫자 테스트")
    void 로또_당첨_번호_중복_숫자_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateDuplicateWinningNumbers("1,2,32,32,35,40"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 쉼표(,)가 아닌 다른 문자인 경우 테스트")
    void 로또_당첨_번호_쉼표_구분_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonCommaWinningNumbers("1/2/3/4/5/6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 쉼표(,)가 아닌 다른 문자인 경우 테스트2")
    void 로또_당첨_번호_쉼표_구분_확인2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonCommaWinningNumbers("1-2,3,4-5,6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 쉼표(,)가 아닌 다른 문자인 경우 테스트3")
    void 로또_당첨_번호_쉼표_구분_확인3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonCommaWinningNumbers("1,2,3,4.5,6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호 쉼표(,)가 아닌 다른 문자인 경우 테스트4")
    void 로또_당첨_번호_쉼표_구분_확인4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputWinningNumbersValidator.validateNonCommaWinningNumbers("1,2,3,4,5&6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
