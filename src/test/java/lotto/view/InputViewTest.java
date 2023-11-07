package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    @Test
    @DisplayName("로또 구입 금액에 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    void inputLottoPurchaseAmountByOnlyInteger() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ErrorMessage.NOT_INTEGER_LOTTO_PURCHASE_AMOUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구입 금액이 0으로 시작하면 예외가 발생한다.")
    void inputLottoPurchaseAmountByStartZero() {
        assertSimpleTest(() -> {
            runException("01000");
            assertThat(output()).contains(ErrorMessage.START_ZERO_LOTTO_PURCHASE_AMOUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void inputLottoPurchaseAmountByDivide1000() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ErrorMessage.NOT_DIVIDE_LOTTO_PURCHASE_MINIMUM_AMOUNT.getMessage());
        });
    }

    @Test
    @DisplayName("로또 당첨 번호에 빈 입력이 들어오면 예외가 발생한다.")
    void inputWinningNumbersByBlankInput() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,");
            assertThat(output()).contains(ErrorMessage.BLANK_LOTTO_WINNING_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("로또 당첨 번호에 숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    void inputWinningNumbersByOnlyInteger() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,wea,4,5,");
            assertThat(output()).contains(ErrorMessage.NOT_INTEGER_WINNING_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("로또 당첨 번호가 0으로 시작하면 예외가 발생한다.")
    void inputWinningNumbersByStartZero() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,05,0,5,");
            assertThat(output()).contains(ErrorMessage.START_ZERO_WINNING_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("로또 당첨 번호가 총 6개가 아니면 예외가 발생한다.")
    void inputWinningNumbersByRightSize() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ErrorMessage.NOT_RIGHT_SIZE_WINNING_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumberByOnlyInteger() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "s");
            assertThat(output()).contains(ErrorMessage.NOT_INTEGER_BONUS_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 0으로 시작하면 예외가 발생한다.")
    void inputBonusNumberByStartZero() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "05");
            assertThat(output()).contains(ErrorMessage.START_ZERO_BONUS_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumberByInRangeLottoNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "75");
            assertThat(output()).contains(ErrorMessage.OVER_RANGE_BONUS_NUMBER.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}