package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.lotto.LottoOutOfRangeException;
import lotto.exception.money.MoneyDivisionException;
import lotto.exception.money.MoneyRangeException;
import lotto.model.Lotto;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createMoneyOutOfRange(){
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(MoneyRangeException.class);
    }

    @DisplayName("금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyNotDividedBy1000(){
        assertThatThrownBy(() -> new Money(1100))
                .isInstanceOf(MoneyDivisionException.class);
    }
}
