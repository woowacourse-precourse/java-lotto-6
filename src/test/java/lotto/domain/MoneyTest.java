package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {


    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000"})
    @DisplayName("입력받은 돈이 Money에 저장되는지 테스트")
    void moneyStoreTest(String input) {

        //given
        Money money = Money.valueOf(input);
        //when

        long expectedMoney = Long.parseLong(input);

        //then
        Assertions.assertThat(money.showMoney()).isEqualTo(expectedMoney);
    }
}
