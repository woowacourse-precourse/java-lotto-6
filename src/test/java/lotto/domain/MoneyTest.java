package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("Money 생성 테스트")
    void createMoneyTest() {
        Money money = new Money(5000);
        assertEquals(money.getMoney(), 5000);
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 값으로 생성 불가능")
    void createMoneyNot1000Multiples() {
        assertThatThrownBy(() -> new Money(5001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoResults 로부터 Money 생성 테스트")
    void createMoneyFromLottoResultsTest() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));
        LottoResults lottoResults = LottoResults.createLottoResults(lottos, winningNumbers);
        Money revenue = Money.from(lottoResults);
        assertThat(revenue.getMoney()).isEqualTo(2000000000);
    }
}