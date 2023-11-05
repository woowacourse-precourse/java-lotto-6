package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("구입 금액 형식에 맞지 않으면 예외가 발생한다.")
    @Test
    void getMoneyByIllegalFormat() {
        assertThatThrownBy(() -> new Money("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}