package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static util.TestUtil.setInput;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoPurchaseMoney;

class InputViewTest {

    InputView inputView = new InputView(new InputValidator());

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @DisplayName("구매금액 입력 테스트")
    @Nested
    class InputLottoPurchaseMoneyTest {

        @DisplayName("정상적인 구매금액을 입력한다.")
        @Test
        void inputPurchaseMoney() {
            // given
            int expect = 5000;

            setInput("5000");

            // when
            LottoPurchaseMoney amount = inputView.askPurchaseMoney();

            // then
            assertThat(amount.toInt()).isEqualTo(expect);
        }

        @DisplayName("빈 문자열을 구매금액으로 입력하면 예외를 발생한다.")
        @Test
        void inputEmptyPurchaseAmount() {
            // given
            setInput("\n");

            // when & then
            assertThatThrownBy(() -> inputView.askPurchaseMoney())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정수로 변환할 수 없는 값을 구매금액으로 입력하면 예외를 발생한다.")
        @Test
        void inputNonDigitPurchaseAmount() {
            // given
            setInput("우테코6기");

            // when & then
            assertThatThrownBy(() -> inputView.askPurchaseMoney())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨금액 입력 테스트")
    @Nested
    class InputLottoWinningNumbersTest {

        @DisplayName("정상적인 당첨번호를 입력한다.")
        @Test
        void inputWinningNumbers() {
            // given
            setInput("3,4,5,6,7,8");

            List<Integer> expected = List.of(3, 4, 5, 6, 7, 8);

            // when
            List<Integer> actual = inputView.askWinningNumbers().stream().toList();

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("빈 문자열을 입력하면 예외를 발생한다.")
        @Test
        void inputEmptyString() {
            // given
            setInput("\n");

            // when & then
            assertThatThrownBy(() -> inputView.askWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨번호 사이에 띄어쓰기를 입력하면 예외를 발생한다.")
        @Test
        void inputSpaceInBetween() {
            // given
            setInput("3 4 5 6 7 8");

            // when & then
            assertThatThrownBy(() -> inputView.askWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨번호 사이에 쉼표와 띄어쓰기를 입력하면 예외를 발생한다.")
        @Test
        void inputCommaAndSpaceInBetween() {
            // given
            setInput("3, 4, 5, 6, 7, 8");

            // when & then
            assertThatThrownBy(() -> inputView.askWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 값을 입력하면 예외를 발생한다.")
        @Test
        void inputNonDigit() {
            // given
            setInput("6,우,아,한,테,크");

            // when & then
            assertThatThrownBy(() -> inputView.askWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스번호 입력 테스트")
    @Nested
    class InputBonusNumberTest {

        @DisplayName("정상적인 보너스번호를 입력한다.")
        @Test
        void inputBonusNumber() {
            // given
            setInput("9");

            int expected = 9;

            // when
            int actual = inputView.askBonusNumber();

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("빈 문자열을 입력하면 예외를 발생한다.")
        @Test
        void inputEmptyString() {
            // given
            setInput("\n");

            // when & then
            assertThatThrownBy(() -> inputView.askBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자가 아닌 값을 입력하면 예외를 발생한다.")
        @Test
        void inputNonDigit() {
            // given
            setInput("우");

            // when & then
            assertThatThrownBy(() -> inputView.askBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
