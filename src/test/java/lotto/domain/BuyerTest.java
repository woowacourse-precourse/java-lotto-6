package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BuyerTest {

    @Test
    void 입력한_구매_금액_1000원_미만_예외_발생() {

        assertThatThrownBy(() -> new Buyer().saveAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_구매_금액_1억원_초과_예외_발생() {

        assertThatThrownBy(() -> new Buyer().saveAmount(100000001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_구매_금액_단위_금액으로_안나누어지면_예외_발생() {

        assertThatThrownBy(() -> new Buyer().saveAmount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void saveAmountTest() {

        Buyer buyer = new Buyer();
        buyer.saveAmount(2000);

        assertThat(buyer.getAmount()).isEqualTo(2);
    }

    @Test
    void saveNumbersTest() {

        Buyer buyer = new Buyer();
        buyer.saveNumbers(List.of(1, 2, 3, 4, 5, 6));
        buyer.saveNumbers(List.of(7, 8, 9, 10, 11, 12));
        buyer.saveNumbers(List.of(13, 14, 15, 16, 17, 18));

        List<Lotto> lottos = buyer.getLottos();

        int i = 1;

        for(Lotto lotto : lottos){
            for(int num : lotto.getNumbers()){

                assertThat(num).isEqualTo(i++);
            }
        }
    }


}
