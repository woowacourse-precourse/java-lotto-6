package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSalesmanTest {

    @DisplayName("총 지불 금액을 1,000으로 나눴을 때 나머지가 0 이상이라면 예외가 발생한다.")
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

    @DisplayName("1개의 로또번호 발행한다.")
    @Test
    void oneLottoCreate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println("생성된 로또 번호 : " + numbers);
    }

}
