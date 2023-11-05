package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("구입 금액이 로또 1장 가격으로 나누어지지 않으면 에러 발생")
    void 구입_금액은_로또_1장_가격으로_나누어_떨어져야한다(){
        //Given
        int money = 9900;

        //When & Then
        assertThatThrownBy(() -> new Money(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 로또 1장 가격으로 나누어지면 정상 실행")
    void 구입_금액이_로또_1장_가격으로_나누어지면_정상_실행() {
        //Given
        int money = 10000;

        //When & Then
        assertDoesNotThrow(() -> new Money(money));
    }

    @Test
    @DisplayName("구입 금액으로 살 수있는 로또의 개수 확인")
    void 구입_금액으로_살_수있는_로또의_개수_확인() {
        //Given
        int money = 10000;
        Money moneyObject = new Money(money);
        int expectedResult = 10000 / 1000;

        //When & Then
        assertThat(moneyObject.getLottoCount()).isEqualTo(expectedResult);
    }
}
