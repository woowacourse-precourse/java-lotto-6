package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.money.MoneyDivisionException;
import lotto.exception.money.MoneyRangeException;
import lotto.model.Budget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {
    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createMoneyOutOfRange(){
        assertThatThrownBy(() -> new Budget(900))
                .isInstanceOf(MoneyRangeException.class);
    }

    @DisplayName("금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyNotDividedBy1000(){
        assertThatThrownBy(() -> new Budget(1100))
                .isInstanceOf(MoneyDivisionException.class);
    }

    @DisplayName("로또 수량 개수 확인 테스트")
    @Test
    void getLottoQuantity(){
        Budget purchasePrice = new Budget(2000);
        assertThat(purchasePrice.getLottoQuantity()).isEqualTo(2);
    }
}
