package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Nested
    @DisplayName("구입 금액 유효성 검사")
    class purchaseAmountTest extends NsTest {
        String purchaseAmount;

        @ParameterizedTest
        @ValueSource(strings = {"가나", "sk", "다"})
        @DisplayName("숫자 형태가 아닌 금액 입력")
        public void invalidInput(String arg) {
            assertSimpleTest(() -> {
                purchaseAmount = arg;
                assertThatIllegalArgumentException().isThrownBy(() -> run(arg))
                        .withMessageStartingWith("잘못된 입력입니다. 유효한 숫자를 입력해주세요.");
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"300", "500", "800"})
        @DisplayName("1000 미만의 금액 입력")
        public void greaterThanThousand(String arg) {

            assertSimpleTest(() -> {
                purchaseAmount = arg;
                assertThatIllegalArgumentException().isThrownBy(() -> run(arg))
                        .withMessageStartingWith("구입 금액은 1000 이상이어야 합니다.");
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"1200", "5500", "8800"})
        @DisplayName("1000으로 나누어 떨어지지 않는 금액 입력")
        public void divisibleByThousand(String arg) {
            assertSimpleTest(() -> {
                purchaseAmount = arg;
                assertThatIllegalArgumentException().isThrownBy(() -> run(arg))
                        .withMessageStartingWith("구입 금액은 1000으로 나누어져야 합니다.");
            });
        }

        @Override
        protected void runMain() {
            InputValidator.validatePurchaseAmount(purchaseAmount);
        }
    }


    @Nested
    @DisplayName("보너스 번호 유효성 검사")
    class BonusNumberTest extends NsTest {
        String bonusNumber;

        @ParameterizedTest
        @ValueSource(strings = {"가나", "sk", "다"})
        @DisplayName("숫자 형태가 아닌 보너스 번호 입력")
        public void invalidInput(String arg) {
            assertSimpleTest(() -> {
                bonusNumber = arg;
                assertThatIllegalArgumentException().isThrownBy(() -> run(arg))
                        .withMessageStartingWith("잘못된 입력입니다. 유효한 숫자를 입력해주세요.");
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"-1", "46", "100"})
        @DisplayName("범위 밖의 보너스 번호 입력")
        public void outOfRange(String arg) {
            assertSimpleTest(() -> {
                bonusNumber = arg;
                assertThatIllegalArgumentException().isThrownBy(() -> run(arg))
                        .withMessageStartingWith("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            });
        }

        @Override
        protected void runMain() {
            InputValidator.validateBonusNumber(bonusNumber);
        }
    }


    @Nested
    @DisplayName("당첨 번호와 보너스 번호 중복 여부 테스트")
    class DuplicateTest {

        @DisplayName("당첨 번호와 보너스 번호 중복 여부 테스트")
        @Test
        public void duplicateWithWinningNumbers() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

            assertThatThrownBy(() -> InputValidator.notInWinningNumbers(winningNumbers, 6))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }


}