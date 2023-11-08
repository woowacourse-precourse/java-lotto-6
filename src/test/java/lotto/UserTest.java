package lotto;

import static lotto.enums.ExceptionCase.INPUT_TYPE_MISMATCH;
import static lotto.enums.ExceptionCase.MONEY_UNIT_MISMATCH;
import static lotto.enums.NumberCondition.MONEY_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static final String VALID_MONEY = "5000";
    private static final User VALID_USER = new User(VALID_MONEY);
    private static final int VALID_COUNT = 5;

    @DisplayName("돈이 양의 정수가 아니면 예외가 발생한다.")
    @Test
    void createUserByNegativeNumber() {
        assertThatThrownBy(() -> new User("-5000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_TYPE_MISMATCH.message());
    }

    @DisplayName("돈의 단위가 올바르지 않으면 예외가 발생한다.")
    @Test
    void createUserByAnotherDigitNumber() {
        assertThatThrownBy(() -> new User("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MONEY_UNIT_MISMATCH.message());
    }

    @DisplayName("입력에 단위만큼 나눈 수가 count이다")
    @Test
    void createCountByMoney() {
        int count = Integer.parseInt(VALID_MONEY) / MONEY_UNIT.number();

        assertThat(count).isEqualTo(VALID_USER.getCount());
    }

    @DisplayName("count만큼 ticket을 생성한다")
    @Test
    void createTicketAsMuchAsCount() {
        assertThatThrownBy(() -> VALID_USER.getTicket(VALID_COUNT))
                .isInstanceOf(IndexOutOfBoundsException.class);
        assertThat(VALID_USER.getTicket(VALID_COUNT - 1))
                .isNotEmpty();
    }

}
