package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
import static lotto.constant.ErrorMessage.NUMBER_IN_RANGE_EXCEPTION;
import static lotto.constant.ErrorMessage.SIZE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 테스트")
class InputViewTest {
    @Nested
    @DisplayName("로또 구입 금액 입력 테스트")
    class PurchaseCost extends NsTest {
        private final String SUCCESSFUL_PURCHASE_COST = "15000";

        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(() -> {
                run(SUCCESSFUL_PURCHASE_COST);
                assertThat(output()).isEqualTo(SUCCESSFUL_PURCHASE_COST);
            });
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            private final String INVALID_TYPE_PURCHASE_COST = "1000a";
            private final String INVALID_MULTIPLE_PURCHASE_COST = "15001";

            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_TYPE_PURCHASE_COST, SUCCESSFUL_PURCHASE_COST);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1000원 단위가 아닌 입력 테스트")
            void invalidMultipleTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_MULTIPLE_PURCHASE_COST, SUCCESSFUL_PURCHASE_COST);
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
        private final String SUCCESSFUL_WINNING_NUMBER = "1,4,6,10,25,33";
        private final String INVALID_TYPE_WINNING_NUMBER = "1,6,10,22,35,a";
        private final String INVALID_RANGE_WINNING_NUMBER = "1,19,25,36,45,50";
        private final String DUPLICATION_WINNING_NUMBER = "1,19,25,36,45,45";
        private final String LESS_SIZE_WINNING_NUMBER = "1,3,6,19,22";
        private final String EXCEED_SIZE_WINNING_NUMBER = "1,3,6,19,22,25,36,45";
        private final List<Integer> SUCCESSFUL_WINNING_NUMBERS = List.of(1, 4, 6, 10, 25, 33);

        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(() -> {
                run(SUCCESSFUL_WINNING_NUMBER);
                assertThat(output()).isEqualTo(SUCCESSFUL_WINNING_NUMBERS.toString());
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
                            run(LESS_SIZE_WINNING_NUMBER, SUCCESSFUL_WINNING_NUMBER);
                            assertThat(output()).contains(SIZE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("6개보다 많은 입력 테스트")
            void exceedSizeTest() {
                assertSimpleTest(
                        () -> {
                            run(EXCEED_SIZE_WINNING_NUMBER, SUCCESSFUL_WINNING_NUMBER);
                            assertThat(output()).contains(SIZE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_TYPE_WINNING_NUMBER, SUCCESSFUL_WINNING_NUMBER);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1부터 45 사이가 아닌 번호 입력 테스트")
            void invalidRangeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_RANGE_WINNING_NUMBER, SUCCESSFUL_WINNING_NUMBER);
                            assertThat(output()).contains(NUMBER_IN_RANGE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("중복되는 번호 입력 테스트")
            void duplicationTest() {
                assertSimpleTest(
                        () -> {
                            run(DUPLICATION_WINNING_NUMBER, SUCCESSFUL_WINNING_NUMBER);
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
        private final String SUCCESSFUL_BONUS_NUMBER = "13";
        private final List<Integer> WINNING_NUMBERS = List.of(1, 4, 6, 10, 25, 33);

        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(() -> {
                run(SUCCESSFUL_BONUS_NUMBER);
                assertThat(output()).isEqualTo(SUCCESSFUL_BONUS_NUMBER);
            });
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            private final String INVALID_TYPE_BONUS_NUMBER = "3a";
            private final String INVALID_RANGE_BONUS_NUMBER = "49";
            private final String DUPLICATION_BONUS_NUMBER = "25";

            @Test
            @DisplayName("숫자가 아닌 입력 테스트")
            void invalidTypeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_TYPE_BONUS_NUMBER, SUCCESSFUL_BONUS_NUMBER);
                            assertThat(output()).contains(DIGIT_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("1부터 45 사이가 아닌 번호 입력 테스트")
            void invalidRangeTest() {
                assertSimpleTest(
                        () -> {
                            run(INVALID_RANGE_BONUS_NUMBER, SUCCESSFUL_BONUS_NUMBER);
                            assertThat(output()).contains(NUMBER_IN_RANGE_EXCEPTION.getMessage());
                        }
                );
            }

            @Test
            @DisplayName("중복되는 번호 입력 테스트")
            void duplicationTest() {
                assertSimpleTest(
                        () -> {
                            run(DUPLICATION_BONUS_NUMBER, SUCCESSFUL_BONUS_NUMBER);
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