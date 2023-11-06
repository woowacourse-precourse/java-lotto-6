package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.money.MoneyDivisionException;
import lotto.exception.money.MoneyRangeException;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceTest {
    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createMoneyOutOfRange(){
        assertThatThrownBy(() -> new PurchasePrice(900))
                .isInstanceOf(MoneyRangeException.class);
    }

    @DisplayName("금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyNotDividedBy1000(){
        assertThatThrownBy(() -> new PurchasePrice(1100))
                .isInstanceOf(MoneyDivisionException.class);
    }
}
