package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static lotto.domain.constant.StringConstant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputServiceTest {
    @DisplayName("숫자 타입이 아닌 금액 입력값에 대해 예외 발생")
    @Test
    void readExpenseOfNoneNumberType() {
        // GIVEN
        System.setIn(new ByteArrayInputStream(TEST_EXPENSE_TYPE.getBytes()));

        // WHEN, THEN
        assertThatThrownBy(InputService::readExpense)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나뉘어지지 않는 금액 입력값에 대해 예외 발생")
    @Test
    void readExpenseOfNoneDividableNumber() {
        // GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_EXPENSE_DIVIDE.getBytes());
        System.setIn(in);

        // WHEN, THEN
        assertThatThrownBy(InputService::readExpense)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 타입이 아닌 당첨 입력값에 대해 예외 발생")
    @Test
    void readWinNumbersOfNoneNumberType() {
        // GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_WINNUMBERS_TYPE.getBytes());
        System.setIn(in);

        // WHEN, THEN
        assertThatThrownBy(InputService::readWinNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 입력값에 대해 정렬된 결과 반환")
    @Test
    void readWinNumberAndReturnSortedList() {
        // GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_WINNUMBERS_SORT.getBytes());
        System.setIn(in);

        // WHEN
        List<Integer> winNumbers = InputService.readWinNumbers();

        // THEN
        assertThat(winNumbers).isSorted();
    }

    @DisplayName("숫자 타입이 아닌 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumberOfNoneNumberType() {
        // GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_BONUSNUMBER_TYPE.getBytes());
        System.setIn(in);

        // WHEN, THEN
        assertThatThrownBy(InputService::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제한된 범위를 넘는 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumberOfNotInRange() {
        // GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_BONUSNUMBER_RANGE.getBytes());
        System.setIn(in);

        // WHEN, THEN
        assertThatThrownBy(InputService::readBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}