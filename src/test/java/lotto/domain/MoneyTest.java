package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("구입 금액이 1000원 미만이면 예외를 발생한다.")
    public void inputMoneyLess1000() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
