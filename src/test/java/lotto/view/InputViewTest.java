package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.InvalidInputException.InvalidInputError.INPUT_NOT_BLANK;
import static lotto.exception.InvalidInputException.InvalidInputError.INVALID_AMOUNT;
import static lotto.exception.InvalidInputException.InvalidInputError.NUMBER_NEED;
import static lotto.exception.InvalidInputException.InvalidInputError.POSITIVE_NUMBER_NEED;
import static lotto.exception.InvalidLottoException.InvalidLottoError.DUPLICATE_LOTTO;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_COUNT;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_RANGE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    @DisplayName("구입 금액 입력 예외 테스트")
    class AmountTest {

        @Test
        @DisplayName("공백 입력은 예외가 발생한다.")
        public void 공백_입력은_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException(" ");
                assertThat(output()).contains(ERROR_MESSAGE, INPUT_NOT_BLANK.getMessage());
            });
        }

        @Test
        @DisplayName("숫자가 아닌 문자열 입력은 예외가 발생한다.")
        public void 숫자가_아닌_문자열_입력은_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("asdf");
                assertThat(output()).contains(ERROR_MESSAGE, NUMBER_NEED.getMessage());
            });
        }

        @Test
        @DisplayName("음수의 입력은 예외가 발생한다.")
        public void 음수의_입력은_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("-10");
                assertThat(output()).contains(ERROR_MESSAGE, POSITIVE_NUMBER_NEED.getMessage());
            });
        }

        @Test
        @DisplayName("ZERO 입력은 예외가 발생한다.")
        public void ZERO_입력은_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("0");
                assertThat(output()).contains(ERROR_MESSAGE, POSITIVE_NUMBER_NEED.getMessage());
            });
            assertSimpleTest(() -> {
                runException("000000");
                assertThat(output()).contains(ERROR_MESSAGE, POSITIVE_NUMBER_NEED.getMessage());
            });
        }

        @Test
        @DisplayName("구입 금액이 1000단위로 나누어떨어지지 않으면 예외가 발생한다.")
        public void 구입_금액이_1000단위로_나누어떨어지지_않으면_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("12345");
                assertThat(output()).contains(ERROR_MESSAGE, INVALID_AMOUNT.getMessage());
            });
        }
    }

    @Nested
    @DisplayName("로또 번호 입력 예외 테스트")
    class LottoTest {

        @Test
        @DisplayName("로또 개수가 일치하지 않을 경우 예외가 발생한다.")
        public void 로또_개수가_일치하지_않을_경우_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("10000\n1,2,3,4,5");
                assertThat(output()).contains(ERROR_MESSAGE, INVALID_LOTTO_COUNT.getMessage());
            });
        }

        @Test
        @DisplayName("로또 숫자의 범위가 유효하지 않을 경우 예외가 발생한다.")
        public void 로또_숫자의_범위가_유효하지_않을_경우_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("10000\n1,2,3,4,5,100");
                assertThat(output()).contains(ERROR_MESSAGE, INVALID_LOTTO_RANGE.getMessage());
            });
        }

        @Test
        @DisplayName("로또 숫자가 중복될 경우 예외가 발생한다.")
        public void 로또_숫자가_중복될_경우_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("10000\n1,2,3,4,5,5");
                assertThat(output()).contains(ERROR_MESSAGE, DUPLICATE_LOTTO.getMessage());
            });
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 예외 테스트")
    class BonusNumberTest {

        @Test
        @DisplayName("보너스 번호의 범위가 유효하지 않으면 예외가 발생한다.")
        public void 보너스_번호의_범위가_유효하지_않으면_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("10000\n1,2,3,4,5,6\n100");
                assertThat(output()).contains(ERROR_MESSAGE, INVALID_LOTTO_RANGE.getMessage());
            });
        }

        @Test
        @DisplayName("보너스 번호가 로또와 중복될 경우 예외가 발생한다.")
        public void 보너스_번호가_로또와_중복될_경우_예외가_발생한다() {
            assertSimpleTest(() -> {
                runException("10000\n1,2,3,4,5,6\n6");
                assertThat(output()).contains(ERROR_MESSAGE, DUPLICATE_LOTTO.getMessage());
            });
        }
    }
}
