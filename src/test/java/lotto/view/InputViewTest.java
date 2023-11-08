package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.BonusNumberTestConstant.BONUS_NUMBER;
import static lotto.constant.BonusNumberTestConstant.DUPLICATION_BONUS_NUMBER;
import static lotto.constant.BonusNumberTestConstant.INVALID_RANGE_BONUS_NUMBER;
import static lotto.constant.BonusNumberTestConstant.INVALID_TYPE_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
import static lotto.constant.ErrorMessage.NUMBER_IN_RANGE_EXCEPTION;
import static lotto.constant.ErrorMessage.SIZE_EXCEPTION;
import static lotto.constant.PaymentAmountTestConstant.INVALID_MULTIPLE_PAYMENT_AMOUNT;
import static lotto.constant.PaymentAmountTestConstant.INVALID_TYPE_PAYMENT_AMOUNT;
import static lotto.constant.PaymentAmountTestConstant.PAYMENT_AMOUNT;
import static lotto.constant.WinningNumberTestConstant.DUPLICATION_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.EXCEED_SIZE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.INVALID_RANGE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.INVALID_TYPE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.LESS_SIZE_WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.WINNING_NUMBER;
import static lotto.constant.WinningNumberTestConstant.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 테스트")
class InputViewTest {
    @Nested
    @DisplayName("로또 구입 금액 입력 테스트")
    class PurchaseCost extends NsTest {
        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(() -> {
                run(PAYMENT_AMOUNT.getValue());
                assertThat(output()).isEqualTo(PAYMENT_AMOUNT.getValue());
            });
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {

            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_TYPE_PAYMENT_AMOUNT.getValue(), PAYMENT_AMOUNT.getValue());
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1000원 단위가 아닌 입력 테스트")
            void invalidMultipleTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_MULTIPLE_PAYMENT_AMOUNT.getValue(), PAYMENT_AMOUNT.getValue());
                            assertThat(output()).contains(MULTIPLE_EXCEPTION.getMessage());
                        }
                );
            }
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            System.out.println(inputView.purchaseCost());
        }
    }

    @Nested
    @DisplayName("당첨 번호 입력 테스트")
    class WinningNumber extends NsTest {
        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(() -> {
                run(WINNING_NUMBER);
                assertThat(output()).isEqualTo(WINNING_NUMBERS.toString());
            });
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("6개보다 적은 입력 테스트")
            void lessSizeTest() {
                assertSimpleTest(
                        () -> {
                            run(LESS_SIZE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(SIZE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("6개보다 많은 입력 테스트")
            void exceedSizeTest() {
                assertSimpleTest(
                        () -> {
                            run(EXCEED_SIZE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(SIZE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_TYPE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1부터 45 사이가 아닌 번호 입력 테스트")
            void invalidRangeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_RANGE_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(NUMBER_IN_RANGE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("중복되는 번호 입력 테스트")
            void duplicationTest() {
                assertSimpleTest(
                        () -> {
                            run(DUPLICATION_WINNING_NUMBER, WINNING_NUMBER);
                            assertThat(output()).contains(DUPLICATION_EXCEPTION.getMessage());
                        }
                );
            }
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            System.out.println(inputView.winningNumber());
        }
    }

    @Nested
    @DisplayName("보너스 번호 입력 테스트")
    class BonusNumber extends NsTest {
        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(() -> {
                run(BONUS_NUMBER);
                assertThat(output()).isEqualTo(BONUS_NUMBER);
            });
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_TYPE_BONUS_NUMBER, BONUS_NUMBER);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1부터 45 사이가 아닌 번호 입력 테스트")
            void invalidRangeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_RANGE_BONUS_NUMBER, BONUS_NUMBER);
                            assertThat(output()).contains(NUMBER_IN_RANGE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("중복되는 번호 입력 테스트")
            void duplicationTest() {
                assertSimpleTest(
                        () -> {
                            run(DUPLICATION_BONUS_NUMBER, BONUS_NUMBER);
                            assertThat(output()).contains(DUPLICATION_EXCEPTION.getMessage());
                        }
                );
            }
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            System.out.println(inputView.bonusNumber(WINNING_NUMBERS));
        }
    }
}