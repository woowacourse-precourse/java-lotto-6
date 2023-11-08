package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[Test] Money")
public class MoneyTest {
    @Test
    @DisplayName("Money 생성 테스트 - 정상")
    void Money_생성_테스트_정상() {
        // Given
        int userInputMoney = 3000;

        // When
        Money money = Money.create(userInputMoney);

        // Then
        assertThat(money.getMoney()).isEqualTo(userInputMoney);
    }

    @Test
    @DisplayName("Money 생성 테스트 - 1000으로 나누어 떨어지지 않는 경우")
    void Money_생성_테스트_1000으로_나누어지지_않을_경우() {
        // Given
        int userInputMoney = 3600;

        // When & Then
        assertThatThrownBy(() -> Money.create(userInputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 발생 개수 테스트")
    void amountOfLottoTest() {
        // Given
        Money money = Money.create(8000);
        int amount = 8000 / 1000;

        // When
        int amountOfLotto = money.amountOfLotto();

        // Then
        assertThat(amountOfLotto).isEqualTo(amount);
    }
}
