package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.record.AmountRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @DisplayName("1000원당 로또가 1장 발행되어야 한다.")
    @Test
    void buyLotto() {
        List<Lotto> lottos = new Amount("3000").buyLotto();
        assertThat(lottos).hasSize(3);
    }

    @DisplayName("toRecord는 Amount의 amount 값을 가진 채 AmountRecord를 반환하여야 한다.")
    @Test
    void toRecord() {
        AmountRecord amountRecord = new Amount("3000").toRecord();
        assertThat(amountRecord.amount()).isEqualTo(3000L);
    }

    @DisplayName("amount 발행 시 입력받는 문자열이 long 형태가 아니면 예외가 발생한다.")
    @Test
    void amountIsNotLong() {
        assertThatThrownBy(() -> new Amount("천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("amount 발행 시 입력받는 문자열이 long 형태가 아니면 예외가 발생한다.")
    @Test
    void amountUnitNotThousandWon() {
        assertThatThrownBy(() -> new Amount("3200"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}