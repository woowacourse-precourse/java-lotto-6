package lotto.service;

import lotto.Application;
import org.junit.jupiter.api.*;

import camp.nextstep.edu.missionutils.test.NsTest;

import static lotto.domain.constant.StringConstant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InputServiceTest extends NsTest {
    // for thread run
    @Order(1)
    @Test
    void forThreadRun() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException();

            // THEN
            assertThat(output()).contains(EXPENSE_INPUT_FORM_MESSAGE);
        });
    }

    // readExpense()
    @DisplayName("숫자 타입이 아닌 금액 입력값에 대해 예외 발생")
    @Test
    void readExpenseOfNoneNumberType() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException("1000j");

            // THEN
            assertThat(output()).contains(ERROR_PREFIX, LOTTO_NUM_TYPE_ERROR);
        });
    }

    @DisplayName("1000으로 나뉘어지지 않는 금액 입력값에 대해 예외 발생")
    @Test
    void readExpenseOfNoneDividableNumber() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException("999");

            // THEN
            assertThat(output()).contains(ERROR_PREFIX, LOTTO_EXPENSE_VALUE_ERROR);
        });
    }


    // readWinningLotto()
    @DisplayName("숫자 타입이 아닌 당첨 입력값에 대해 예외 발생")
    @Test
    void readWinningLottoOfNoneNumberType() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException(
                    "1000",
                    "a, 2, 3, 4, 5, 6"
                    );

            // THEN
            assertThat(output()).contains(ERROR_PREFIX, LOTTO_NUM_TYPE_ERROR);
        });
    }


    // readBonusNum()
    @DisplayName("숫자 타입이 아닌 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumOfNoneNumberType() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException(
                    "1000",
                    "1,2,3,4,5,6",
                    "a"
            );

            // THEN
            assertThat(output()).contains(ERROR_PREFIX, LOTTO_NUM_TYPE_ERROR);
        });
    }

    @DisplayName("제한된 범위를 넘는 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumOfNotInRange() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException(
                    "1000",
                    "1,2,3,4,5,6",
                    "46"
            );

            // THEN
            assertThat(output()).contains(ERROR_PREFIX, LOTTO_IN_RANGE_ERROR);
        });
    }

    @DisplayName("기존 로또 번호와 동일한 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumOfDuplicate() {
        assertSimpleTest(() -> {
            // GIVEN, WHEN
            runException(
                    "1000",
                    "1,2,3,4,5,6",
                    "1"
            );

            // THEN
            assertThat(output()).contains(ERROR_PREFIX, LOTTO_BONUSNUM_DUPLICATE_ERROR);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}