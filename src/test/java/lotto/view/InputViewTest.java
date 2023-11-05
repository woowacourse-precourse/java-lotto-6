package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
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
}