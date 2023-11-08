package lotto.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Nested
    class LottoWinningNumbersMethodTest {
        @DisplayName("빈칸 및 아무것도 받지 않는 경우 예외가 발생한다")
        @Test
        void blankOrNothing() {
            String input = "";
            assertThatThrownBy(() -> Parser.parseLottoWiningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("여섯개의 숫자중 빈칸이 들어간 경우 예외가 발생한다.")
        @Test
        void fiveNumberOneBlank() {
            String input = "1,2,3,4,5, ";
            assertThatThrownBy(() -> Parser.parseLottoWiningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("여섯개의 숫자중 숫자가 아닌 다른 타입이 들어간 경우 예외가 발생한다")
        @Test
        void fourNumberTwoString() {
            String input = "1,2,3,4,hi,Kzerojun";
            assertThatThrownBy(() -> Parser.parseLottoWiningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자를 입력받지 않는 경우 예외가 발생한다")
        @Test
        void notNumber() {
            String input = "Kzerojun";
            assertThatThrownBy(() -> Parser.parseLottoWiningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("반환 타입이 Lotto인지")
        @Test
        void isTypeLotto() {
            String input = "1,2,3,4,5,6";
            Lotto result = Parser.parseLottoWiningNumbers(input);
            assertTrue(result instanceof Lotto);
        }

    }

    @Nested
    class LottoBonusNumberMethodTest {

        @DisplayName("빈칸 및 아무것도 받지 않는 경우 예외가 발생한다")
        @Test
        void blankOrNothing() {
            String input = "";
            assertThatThrownBy(() -> Parser.parseLottoBonusNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자를 입력받지 않는 경우 예외가 발생한다")
        @Test
        void notNumber() {
            String input = "Kzerojun";
            assertThatThrownBy(() -> Parser.parseLottoBonusNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("반환타입이 BonusNumber인지")
        @Test
        void isTypeBonusNumber() {
            String input = "3";
            BonusNumber bonusNumber = Parser.parseLottoBonusNumber(input);
            assertTrue(bonusNumber instanceof BonusNumber);
        }
    }

    @Nested
    class PurChaseAmountMethodTest {
        @DisplayName("빈칸 및 아무것도 받지 않는 경우 예외가 발생한다")
        @Test
        void blankOrNothing() {
            String input = "";
            assertThatThrownBy(() -> Parser.parsePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자를 입력받지 않는 경우 예외가 발생한다")
        @Test
        void notNumber() {
            String input = "Kzerojun";
            assertThatThrownBy(() -> Parser.parsePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("반환타입이 int 인지")
        @Test
        void 인트_타입_반환() {
            String input = "3";
            int number = Parser.parsePurchaseAmount(input);
            assertEquals(3, number);
        }
    }
}
