package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSalesmanTest {

    @DisplayName("총 지불 금액을 1,000으로 나눴을 때 나머지가 없어야 함")
    @Test
    void lottoCount() {
        int[] moneyValues = {5000, 6005, 7231, 8493, 9000};

        for (int money : moneyValues) {
            if (money % 1000 != 0) {
                System.out.println("[ERROR] 예외처리 money : " + money);
            }

            int lottoNumber = money / 1000;
            System.out.println("money : " + money + " 몫 : " + lottoNumber);
            assertThat(lottoNumber).isEqualTo(money / 1000);
        }
    }
}
