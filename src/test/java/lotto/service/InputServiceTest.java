package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static lotto.domain.constant.StringConstant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputServiceTest {
    private static InputStream original;

    @BeforeAll
    void setUp() {
        original = System.in;
    }

    @AfterAll
    void tearDown() {
        System.setIn(original);
    }

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
        assertThatThrownBy(InputService::readWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 입력값에 대해 정렬된 결과 반환")
    @Test
    void readWinNumberAndReturnSortedList() {
        // GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream(TEST_WINNUMBERS_SORT.getBytes());
        System.setIn(in);

        // WHEN
        List<Integer> winNumbers = InputService.readWinningNumbers();

        // THEN
        assertThat(winNumbers).isSorted();
    }

    @DisplayName("숫자 타입이 아닌 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumberOfNoneNumberType() {
        // GIVEN
        Lotto winningLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        ByteArrayInputStream in = new ByteArrayInputStream(TEST_BONUSNUMBER_TYPE.getBytes());
        System.setIn(in);

        // WHEN, THEN
        assertThatThrownBy(() -> InputService.readBonusNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제한된 범위를 넘는 보너스 입력값에 대해 예외 발생")
    @Test
    void readBonusNumberOfNotInRange() {
        // GIVEN
        Lotto winningLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        ByteArrayInputStream in = new ByteArrayInputStream(TEST_BONUSNUMBER_RANGE.getBytes());
        System.setIn(in);

        // WHEN, THEN
        assertThatThrownBy(() -> InputService.readBonusNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}