package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("Money 객체가 재대로 생성 되는지 테스트")
    void createMoney() {
        String input = "3000";
        Money money = new Money(input);
        assertThat(money).isNotNull();
    }

}