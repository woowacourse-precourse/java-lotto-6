package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Amount;
import lotto.model.Cash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @DisplayName("toRecord는 Amount의 amount 값을 가진 채 AmountRecord를 반환하여야 한다")
    @Test
    void toRecord() {
        assertSimpleTest(() -> assertThat(new Amount("3000")
                .toRecord()
                .amount())
                .isEqualTo(3000L));
    }

    @DisplayName("amount 발행 시 입력받는 문자열이 long 형태가 아니면 예외가 발생한다")
    @Test
    void amountIsNotLong() {
        assertThatThrownBy(() -> new Amount("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("amount 발행 시 입력받는 문자열이 천의 자리가 아니면 예외가 발생한다.")
    @Test
    void amountUnitNotThousandWon() {
        assertThatThrownBy(() -> new Amount("3200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("Amount 생성 시 같은 값의 Cash를 생성하여야 한다.")
    @Test
    void getAmountCash() {
        assertSimpleTest(
                () -> assertThat(new Amount("3000").getAmountCash().cash())
                        .isEqualTo(new Cash("3000").cash()));
    }
}